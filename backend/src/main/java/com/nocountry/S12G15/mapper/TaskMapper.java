package com.nocountry.S12G15.mapper;

import com.nocountry.S12G15.domain.entity.TaskEntity;
import com.nocountry.S12G15.dto.request.TaskRequestDTO;
import com.nocountry.S12G15.dto.response.TaskResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskMapper {

    TaskResponseDTO getTaskDto(TaskEntity taskEntity);

    TaskEntity getTaskEntity(TaskRequestDTO taskRequestDTO);

    List<TaskResponseDTO> toTaskDtoList(List<TaskEntity> taskEntityList);

    List<TaskEntity> toTaskEntityList(List<TaskRequestDTO> taskReqDTOList);

    List<TaskEntity> toTaskEntityListFromResponseDTO(List<TaskResponseDTO> taskResponseDTOS);

    List<TaskResponseDTO> toTaskResponseDTO(List<TaskEntity> taskResponseDTOList);

    List<TaskRequestDTO> toTaskRequestDTOList(List<TaskEntity> taskEntityList);
}
