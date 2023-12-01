package com.nocountry.S12G15.service;

import com.nocountry.S12G15.domain.entity.TaskEntity;
import com.nocountry.S12G15.dto.TaskDTO;
import com.nocountry.S12G15.dto.request.PageableDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TaskService {

    Page<TaskDTO> findAll(PageableDto pageableDto);

    Optional<TaskDTO> findTaskById(String idTask);//TODO: debe devolver un DTO

    TaskDTO createTask(TaskDTO taskDTO); //TODO: debe usar un DTO

    TaskEntity disabledOneById(String idTask);

    TaskDTO updateTask(TaskDTO taskUpdate, String idTask);
}
