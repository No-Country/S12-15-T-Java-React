package com.nocountry.S12G15.mapper;
import com.nocountry.S12G15.domain.entity.SpaceEntity;
import com.nocountry.S12G15.dto.response.SpaceResponseDTO;
import com.nocountry.S12G15.domain.entity.UserEntity;
import com.nocountry.S12G15.dto.request.UserRequestDTO;
//import com.nocountry.S12G15.dto.response.SpaceResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SpaceMapper {

    SpaceResponseDTO toSpaceResponseDto(UserEntity userEntity);

    SpaceEntity toSpaceEntity (UserRequestDTO userRequestDTO);
    //List<SpaceResponseDTO> toTransactionRequestDtoList(List<SpaceEntity> transactionEntityList);
}
