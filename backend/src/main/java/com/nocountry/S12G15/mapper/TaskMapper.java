package com.nocountry.S12G15.mapper;

import com.nocountry.S12G15.domain.entity.TaskEntity;
import com.nocountry.S12G15.dto.TaskDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING) //TODO: uses Permission
public interface TaskMapper {

    @Mapping(source = "description", target = "descriptionDTO")
    @Mapping(source = "name", target = "nameDTO")
    TaskDTO toGetDto(TaskEntity taskEntity); //TODO: response

    @InheritInverseConfiguration
    TaskEntity toGetEntity(TaskDTO taskDTO); //TODO: request

    //TODO: lista permissions
}
