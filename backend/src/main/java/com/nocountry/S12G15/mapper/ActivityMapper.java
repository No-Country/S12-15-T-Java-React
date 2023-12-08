package com.nocountry.S12G15.mapper;

import com.nocountry.S12G15.domain.entity.ActivityEntity;
import com.nocountry.S12G15.dto.ActivityDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ActivityMapper {

    ActivityDTO activityToActivityDTO(ActivityEntity activity);

    ActivityEntity activityDTOToActivity(ActivityDTO activityDTO);

    List<ActivityDTO> toActivityDtoList(List<ActivityEntity> activityEntityList);

    List<ActivityEntity> toActivityEntityList(List<ActivityDTO> activityDTOList);

}
