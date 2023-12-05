package com.nocountry.S12G15.service.impl;

import com.nocountry.S12G15.controller.dto.request.SpaceRequest;
import com.nocountry.S12G15.persistance.repository.SpaceRepo;
import com.nocountry.S12G15.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
public class SpaceServiceImpl implements SpaceService {
    @Autowired

    SpaceRepo spaceRepo;

    public SpaceRepo save(SpaceRepo space){
        return SpaceRepo.save(space);
    }

    public SpaceRepo createSpace(SpaceRequest spaceRequest) {
        SpaceRepo spaceRepo = new space(spaceRequest.getName(), spaceRequest.getDescription());
        return save(SpaceRepo);
    }
}
