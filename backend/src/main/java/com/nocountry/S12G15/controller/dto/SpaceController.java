package com.nocountry.S12G15.controller.dto;
import com.nocountry.S12G15.dto.SpaceDto;
//import com.nocountry.S12G15.service.impl.SpaceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import com.nocountry.S12G15.domain.entity.SpaceEntity;
//import com.nocountry.S12G15.dto.request.SpaceRequest;

import com.nocountry.S12G15.persistance.repository.SpaceRepo;
import com.nocountry.S12G15.service.SpaceService;

import java.util.List;

//import org.springframework.stereotype.Service;
@RestController
public class SpaceController {
    @Autowired
    SpaceService spaceService;
    @Autowired
    SpaceRepo spaceRepo;
    // Creando Espacio de Trabajo
    @PostMapping("/create")
    public ResponseEntity<?> newSpace(@RequestBody SpaceDto newSpace) {
        SpaceDto spaceDto = spaceService.create(newSpace);
        return new ResponseEntity<>(spaceDto, HttpStatus.CREATED);
    }

    // Actualizando los espacios de Trabajo
    @GetMapping("/getAll")
    public ResponseEntity<List<SpaceDto>> getAllSpace() {
        return new ResponseEntity(spaceService.allspace(),HttpStatus.OK) ;
    }
//probando
    // Actualizando por ID
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateSpace(@PathVariable Long id, @RequestBody SpaceDto updatedSpace) {
        SpaceDto spaceDto = spaceService.update(updatedSpace,id);
        return new ResponseEntity<>(spaceDto,HttpStatus.OK) ;
    }
    // Eliminando por ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSpace(@PathVariable Long id) {
        spaceService.delete(id);
        return new ResponseEntity<>( "eliminado", HttpStatus.OK);
    }
}