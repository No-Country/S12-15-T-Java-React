package com.nocountry.S12G15.mapper;

import com.nocountry.S12G15.domain.entity.SpaceEntity;
import com.nocountry.S12G15.dto.request.SpaceRequestDTO;
import com.nocountry.S12G15.dto.response.SpaceResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SpaceMapper {

    SpaceResponseDTO spaceToSpaceResponseDto(SpaceEntity spaceEntity);

    SpaceEntity spaceRequestDTOToSpaceEntity(SpaceRequestDTO spaceRequestDTO);

    SpaceEntity spaceResponseDTOToSpaceEntity (SpaceResponseDTO spaceResponseDTO);

    List<SpaceResponseDTO> toSpaceResponseDtoList(List<SpaceEntity> spaceEntityList);

    List<SpaceEntity> toSpaceEntityList(List<SpaceRequestDTO> spaceRequestDTOList);
}
