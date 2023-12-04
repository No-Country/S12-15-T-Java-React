package com.nocountry.S12G15.mapper;

import com.nocountry.S12G15.domain.entity.UserEntity;
import com.nocountry.S12G15.dto.request.UserRequestDTO;
import com.nocountry.S12G15.dto.response.UserResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING
       )
public interface UserMapper {

    UserResponseDTO toUserResponseDto(UserEntity userEntity);

    UserEntity toUserEntity (UserRequestDTO userRequestDTO);
    List<UserResponseDTO> toUserResponseDTOList(List<UserEntity> transactionEntityList);
}
