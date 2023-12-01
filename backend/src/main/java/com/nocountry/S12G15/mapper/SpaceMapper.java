package com.nocountry.S12G15.mapper;

import com.nocountry.S12G15.domain.entity.SpaceEntity;
import com.nocountry.S12G15.domain.entity.UserEntity;
import com.nocountry.S12G15.dto.response.SpaceResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

/*
    UserResponseDTO toUserResponseDto(UserEntity userEntity);

    UserEntity toUserEntity (UserRequestDTO userRequestDTO);
    List<UserResponseDTO> toUserResponseDTOList(List<UserEntity> transactionEntityList);
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SpaceMapper {
    SpaceResponseDTO toSpaceResponseDto(SpaceEntity spaceEntity);

    SpaceEntity toSpaceEntity (SpaceResponseDTO spaceResponseDTO);
    List<SpaceResponseDTO> toSpaceResponseDTOList(List<SpaceEntity> spaceEntityList);
}
