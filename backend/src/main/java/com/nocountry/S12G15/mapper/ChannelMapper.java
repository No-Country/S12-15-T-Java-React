package com.nocountry.S12G15.mapper;

import com.nocountry.S12G15.domain.entity.BoardEntity;
import com.nocountry.S12G15.domain.entity.ChannelEntity;
import com.nocountry.S12G15.dto.request.ChannelRequestDTO;
import com.nocountry.S12G15.dto.response.ChannelResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {BoardEntity.class})
public interface ChannelMapper {

    @Mapping(source ="status" , target="status" )
    ChannelResponseDTO toGetChannelResponseDto(ChannelEntity channelEntity);
    ChannelEntity toGetChannelEntity(ChannelRequestDTO channelRequestDTO);

    ChannelEntity toGetChannelEntityFromChannelResponseDTO(ChannelResponseDTO channelResponseDTO);

    List<ChannelResponseDTO> toChannelResponseDtoList(List<ChannelEntity> channelEntityList);
    List<ChannelRequestDTO> toChannelRequestDtoList(List<ChannelEntity> channelEntityList);

    List<ChannelEntity> toChannelEntityList(List<ChannelRequestDTO> channelRequestDTOList);
}
