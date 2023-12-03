package com.nocountry.S12G15.service.impl;

import com.nocountry.S12G15.domain.entity.TaskEntity;
import com.nocountry.S12G15.dto.request.PageableDto;
import com.nocountry.S12G15.dto.request.TaskRequestDTO;
import com.nocountry.S12G15.dto.response.TaskResponseDTO;
import com.nocountry.S12G15.exception.GenericException;
import com.nocountry.S12G15.exception.ObjectNotFoundException;
import com.nocountry.S12G15.mapper.TaskMapper;
import com.nocountry.S12G15.persistance.repository.TaskRepository;
import com.nocountry.S12G15.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskMapper mapper;
//    private final Utility utility;
    private final TaskRepository taskRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<TaskResponseDTO> findAll(PageableDto pageableDto){
        //        Pageable pageable = utility.setPageable(pageableDto);
//        Page<TaskEntity> tasks = taskRepository.findAll(pageable);
//
//        List<TaskResponseDTO> taskDTOList = tasks.getContent()
//                .stream()
//                .map(mapper::getTaskDto)
//                .toList();
//
//        return new PageImpl<>(taskDTOList);
        return  null;
    }

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
    public TaskResponseDTO createTask(TaskRequestDTO taskReqDTO) {

        TaskEntity task;
        task =mapper.getTaskEntity(taskReqDTO);
        task.setEnabled(true);
        TaskEntity savedTask = taskRepository.save(task);
        return mapper.getTaskDto(savedTask);
//        TaskEntity taskSlave;
//        taskSlave = Optional.of(taskReqDTO)
//                .map(mapper::getTaskEntity)
//                .map(taskRepository::save)
//                .orElseThrow(()->new GenericException("Oops ocurrió un error", HttpStatus.BAD_REQUEST));
//        return mapper.getTaskDto(taskSlave);

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
    public TaskResponseDTO updateTask(TaskRequestDTO taskUpdate, String idTask) {
        Function<TaskRequestDTO, Optional<TaskEntity>> taskId = taskDTO -> taskRepository.findById(idTask);
        Optional<TaskEntity> taskEntity = taskId.apply(taskUpdate);
        if(taskEntity.isEmpty()){
            throw new ObjectNotFoundException("No se encontró una tarea con este id: "+idTask);
        }
        TaskEntity updateTask = taskEntity.get().updateTask(taskUpdate);
        TaskEntity saveTask = taskRepository.save(updateTask);
        return mapper.getTaskDto(saveTask);
    }


}
