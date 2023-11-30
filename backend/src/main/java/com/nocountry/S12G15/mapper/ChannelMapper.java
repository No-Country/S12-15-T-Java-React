package com.nocountry.S12G15.mapper;

import com.nocountry.S12G15.domain.entity.ChannelEntity;
import com.nocountry.S12G15.dto.ChannelDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)//TODO uses board
public interface ChannelMapper {

    ChannelDto toGetDto(ChannelEntity channelEntity); //TODO response

    @InheritInverseConfiguration
    ChannelEntity toGetEntity(ChannelDto channelDto);//TODO request

    //TODO listas

    //culiado hace las cosas
}
