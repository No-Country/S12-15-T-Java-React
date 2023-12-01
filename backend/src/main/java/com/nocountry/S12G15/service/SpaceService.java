package com.nocountry.S12G15.service;

import com.nocountry.S12G15.domain.entity.SpaceEntity;
import com.nocountry.S12G15.dto.response.SpaceResponseDTO;

import java.util.List;
import java.util.Optional;

public interface SpaceService {
    List<SpaceResponseDTO> getAllSpaces();

    SpaceResponseDTO getSpaceById(Long idSpace);
}
