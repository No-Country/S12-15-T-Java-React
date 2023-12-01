package com.nocountry.S12G15.service.impl;

import com.nocountry.S12G15.domain.entity.SpaceEntity;
import com.nocountry.S12G15.dto.response.SpaceResponseDTO;
import com.nocountry.S12G15.mapper.SpaceMapper;
import com.nocountry.S12G15.persistance.repository.SpaceRepository;
import com.nocountry.S12G15.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpaceServiceImpl implements SpaceService {

    private final SpaceRepository spaceRepository;
    private final SpaceMapper spaceMapper;

    @Autowired
    public SpaceServiceImpl(SpaceRepository spaceRepository, SpaceMapper spaceMapper) {
        this.spaceRepository = spaceRepository;
        this.spaceMapper = spaceMapper;
    }
    @Override
    public List<SpaceResponseDTO> getAllSpaces() {
        List<SpaceEntity> spaceEntityList = spaceRepository.findAll();

        return  spaceMapper.toSpaceResponseDTOList(spaceEntityList);
    }

    @Override
    public SpaceResponseDTO getSpaceById(Long idSpace) {
        Optional<SpaceEntity> spaceEntity = spaceRepository.findById(idSpace);
        if(spaceEntity.isPresent()){
            return spaceMapper.toSpaceResponseDto(spaceEntity.get());
        }
        return null;
    }
}
