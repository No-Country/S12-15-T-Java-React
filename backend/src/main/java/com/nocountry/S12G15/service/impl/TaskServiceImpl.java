package com.nocountry.S12G15.service.impl;

import com.nocountry.S12G15.domain.entity.ActivityEntity;
import com.nocountry.S12G15.domain.entity.TaskEntity;
import com.nocountry.S12G15.dto.request.TaskRequestDTO;
import com.nocountry.S12G15.dto.response.TaskResponseDTO;
import com.nocountry.S12G15.exception.ExceptionMethods;
import com.nocountry.S12G15.exception.MyException;
import com.nocountry.S12G15.exception.ObjectNotFoundException;
import com.nocountry.S12G15.mapper.TaskMapper;
import com.nocountry.S12G15.persistance.repository.ActivityRepository;
import com.nocountry.S12G15.persistance.repository.TaskRepository;
import com.nocountry.S12G15.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskMapper mapper;
    private final TaskRepository taskRepository;
    private final ActivityRepository activityRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<TaskResponseDTO>> findAllTasks(){

        return  Optional.of(mapper.toTaskDtoList(taskRepository.findAll()));

    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TaskResponseDTO> findTaskById(String idTask) {
        Function<String, Optional<TaskEntity>> function=taskRepository::findById;
        TaskEntity taskEntity = function.apply(idTask).orElseThrow(()-> new ObjectNotFoundException("No se encontro la tarea " + idTask));
        return  Optional.of(mapper.getTaskDto(taskEntity));
    }

    @Override
    @Transactional
    public TaskResponseDTO createTask(TaskRequestDTO taskReqDTO) throws MyException {

        validate(taskReqDTO);

        TaskEntity task = mapper.getTaskEntity(taskReqDTO);
        task.setEnabled(true);
        TaskEntity savedTask = taskRepository.save(task);
        return mapper.getTaskDto(savedTask);
    }

    @Override
    @Transactional
    public TaskEntity disabledOneById(String idTask) {
        TaskEntity task = taskRepository.findById(idTask).orElseThrow(()-> new ObjectNotFoundException("Task Not Found"+ idTask));
        task.setEnabled(false);
        return taskRepository.save(task);
    }

    @Override
    @Transactional
    public TaskResponseDTO updateTask(TaskRequestDTO taskUpdate, String idTask) throws MyException {

        validate(taskUpdate);

        Function<TaskRequestDTO, Optional<TaskEntity>> taskId = taskDTO -> taskRepository.findById(idTask);
        Optional<TaskEntity> taskEntity = taskId.apply(taskUpdate);
        if(taskEntity.isEmpty()){
            throw new ObjectNotFoundException("No se encontró una tarea con este id: "+idTask);
        }
        TaskEntity updateTask = taskEntity.get().updateTask(taskUpdate);
        TaskEntity saveTask = taskRepository.save(updateTask);
        return mapper.getTaskDto(saveTask);
    }

    @Override
    public TaskResponseDTO addActivityToTask(String idTask, String idActivity) {

        TaskEntity task = taskRepository.findById(idTask).orElseThrow();
        ActivityEntity activity = activityRepository.findById(idActivity).orElseThrow();

        task.getActivities().add(activity);
        task = taskRepository.save(task);

        return mapper.getTaskDto(task);
    }

     private void validate(TaskRequestDTO taskRequestDTO) throws MyException {
        if (taskRequestDTO.getDescription()== null || ExceptionMethods.onlySpaces(taskRequestDTO.getDescription())) {
            throw new MyException("Task's name can't be null or empty.");
        }
      }

    @Override
    public List<TaskResponseDTO> getEnabledTasks() {
        List<TaskResponseDTO> tasksDTO = findAllTasks().orElseThrow();

        return tasksDTO.stream().filter(TaskResponseDTO::isEnabled).collect(Collectors.toList());
    }

    @Override
    public TaskResponseDTO enableTask(String idTask) {

        TaskEntity task = taskRepository.findById(idTask).orElseThrow();

        task.setEnabled(true);

        TaskEntity savedTask = taskRepository.save(task);

        return mapper.getTaskDto(savedTask);

    }

}
