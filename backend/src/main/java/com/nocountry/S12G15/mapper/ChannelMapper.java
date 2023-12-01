package com.nocountry.S12G15.mapper;

import com.nocountry.S12G15.domain.entity.BoardEntity;
import com.nocountry.S12G15.domain.entity.ChannelEntity;
import com.nocountry.S12G15.dto.ChannelDto;
import com.nocountry.S12G15.dto.request.ChannelRequestDTO;
import com.nocountry.S12G15.dto.response.ChannelResponseDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {BoardEntity.class})//TODO uses board
public interface ChannelMapper {

    ChannelResponseDTO toGetChannelResponseDto(ChannelEntity channelEntity); //TODO response
    ChannelEntity toGetChannelEntity(ChannelRequestDTO channelRequestDTO);//TODO request

    //TODO listas
    List<ChannelRequestDTO> toChannelRequestDtoList(List<ChannelEntity> channelEntityList);

    List<ChannelEntity> toChannelEntityList(List<ChannelRequestDTO> channelRequestDTOList);

    //culiado hace las cosas,ya las hice Culiauuuu , jajjajja, alta documentacion, jjajjaja
}
