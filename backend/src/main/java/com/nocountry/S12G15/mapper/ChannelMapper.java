package com.nocountry.S12G15.mapper;

import com.nocountry.S12G15.domain.entity.BoardEntity;
import com.nocountry.S12G15.domain.entity.ChannelEntity;
import com.nocountry.S12G15.domain.entity.SpaceEntity;
import com.nocountry.S12G15.dto.ChannelDto;
import com.nocountry.S12G15.dto.request.ChannelRequestDTO;
import com.nocountry.S12G15.dto.response.ChannelResponseDTO;
import com.nocountry.S12G15.dto.response.SpaceResponseDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {BoardEntity.class})//TODO uses board
public interface ChannelMapper {

    @Mapping(source ="status" , target="status" )
    ChannelResponseDTO toGetChannelResponseDto(ChannelEntity channelEntity); //TODO response
    ChannelEntity toGetChannelEntity(ChannelRequestDTO channelRequestDTO);//TODO request

    ChannelEntity toGetChannelEntityFromChannelResponseDTO(ChannelResponseDTO channelResponseDTO);//TODO response
    //TODO listas

    List<ChannelResponseDTO> toChannelResponseDtoList(List<ChannelEntity> channelEntityList);
    List<ChannelRequestDTO> toChannelRequestDtoList(List<ChannelEntity> channelEntityList);

    List<ChannelEntity> toChannelEntityList(List<ChannelRequestDTO> channelRequestDTOList);
}
