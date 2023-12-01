package com.nocountry.S12G15.service.impl;

import com.nocountry.S12G15.domain.entity.TaskEntity;
import com.nocountry.S12G15.dto.TaskDTO;
import com.nocountry.S12G15.dto.request.PageableDto;
import com.nocountry.S12G15.exception.ObjectNotFoundException;
import com.nocountry.S12G15.mapper.TaskMapper;
import com.nocountry.S12G15.persistance.repository.TaskRepository;
import com.nocountry.S12G15.service.TaskService;
import com.nocountry.S12G15.util.Utility;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskMapper mapper;
    private final Utility utility;
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Page<TaskDTO> findAll(PageableDto pageableDto){

        Pageable pageable = utility.setPageable(pageableDto);
        Page<TaskEntity> tasks = taskRepository.findAll(pageable);

        List<TaskDTO> taskDTOList = tasks.getContent().stream().map(mapper::toGetDto).toList();

        return new PageImpl<>(taskDTOList);

    }

    @Override
    public Optional<TaskDTO> findTaskById(String idTask) {
        Function<String, Optional<TaskEntity>> function=taskRepository::findById;
        TaskEntity taskEntity = function.apply(idTask).orElseThrow(()-> new ObjectNotFoundException("No se encontro la tarea " + idTask));
        return  Optional.of(mapper.toGetDto(taskEntity));
    }

    @Override
    public TaskDTO createTask(TaskDTO taskDTO) {
        return null; //TODO
    }

    @Override
    public TaskEntity disabledOneById(String idTask) {
        TaskEntity task = taskRepository.findById(idTask).orElseThrow(()-> new ObjectNotFoundException("Task Not Found"+ idTask));
        task.setStatus(TaskEntity.TaskStatus.DISABLED);
        return taskRepository.save(task);
    }

    @Override
    public TaskDTO updateTask(TaskDTO taskUpdate, String idTask) {
        return null;
    }


}
