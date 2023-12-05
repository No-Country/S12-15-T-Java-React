package com.nocountry.S12G15.controller.dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nocountry.S12G15.domain.entity.SpaceEntity;
import com.nocountry.S12G15.controller.dto.request.SpaceRequest;

import com.nocountry.S12G15.persistance.repository.SpaceRepo;
import com.nocountry.S12G15.service.SpaceService;
//import org.springframework.stereotype.Service;
@RestController
public class SpaceController {
    @Autowired
    SpaceService spaceService;
    @Autowired
    SpaceRepo spaceRepo;

// Crea un Espacio de Trabajo

    @PostMapping("/space")
    public ResponseEntity<SpaceEntity> createSpace(@RequestBody SpaceRequest spaceRequest) {
        SpaceEntity space = spaceService.createSpace(spaceRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(space);
    }
}
