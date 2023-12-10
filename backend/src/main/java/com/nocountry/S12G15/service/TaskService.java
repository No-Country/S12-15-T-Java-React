package com.nocountry.S12G15.service;

import com.nocountry.S12G15.domain.entity.TaskEntity;
import com.nocountry.S12G15.dto.request.TaskRequestDTO;
import com.nocountry.S12G15.dto.response.TaskResponseDTO;
import com.nocountry.S12G15.exception.MyException;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    Optional<List<TaskResponseDTO>> findAllTasks();

    Optional<TaskResponseDTO> findTaskById(String idTask);

    TaskResponseDTO createTask(TaskRequestDTO taskDTO) throws MyException;

    TaskEntity disabledOneById(String idTask);

    TaskResponseDTO updateTask(TaskRequestDTO taskUpdate, String idTask) throws MyException;

    TaskResponseDTO addActivityToTask(String idTask, String idActivity);

    List<TaskResponseDTO> getEnabledTasks();

    TaskResponseDTO enableTask(String idTask);
}
