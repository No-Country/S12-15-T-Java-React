package com.nocountry.S12G15.service.impl;

//import com.nocountry.S12G15.dto.request.SpaceRequest;
import com.nocountry.S12G15.dto.SpaceDto;
import com.nocountry.S12G15.persistance.repository.SpaceRepo;
import com.nocountry.S12G15.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SpaceServiceImpl implements SpaceService {


    @Autowired
    SpaceRepo spaceRepo;

    @Override
    public void delete(Long id) {

    }

    @Override
    public SpaceDto update(SpaceDto updatedSpace, Long id) {
        return null;
    }

    @Override
    public SpaceDto create(SpaceDto newSpace) {
        return null;
    }

    @Override
    public Object allspace() {
        return null;
    }
}
