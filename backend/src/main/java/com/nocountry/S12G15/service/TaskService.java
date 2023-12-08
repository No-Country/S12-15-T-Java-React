package com.nocountry.S12G15.service;

import com.nocountry.S12G15.domain.entity.TaskEntity;
import com.nocountry.S12G15.dto.ActivityDTO;
import com.nocountry.S12G15.dto.request.PageableDto;
import com.nocountry.S12G15.dto.request.TaskRequestDTO;
import com.nocountry.S12G15.dto.response.TaskResponseDTO;
import com.nocountry.S12G15.exception.MyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    Optional<List<TaskResponseDTO>> findAllTasks();
    Page<TaskResponseDTO> findAll(Pageable pageable);

    Optional<TaskResponseDTO> findTaskById(String idTask);

    TaskResponseDTO createTask(TaskRequestDTO taskDTO);

    TaskEntity disabledOneById(String idTask);

    TaskResponseDTO updateTask(TaskRequestDTO taskUpdate, String idTask);

    TaskResponseDTO addActivityToTask(String idTask, String idActivity) throws MyException;
}
