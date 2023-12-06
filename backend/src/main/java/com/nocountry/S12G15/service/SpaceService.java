package com.nocountry.S12G15.service;


import com.nocountry.S12G15.dto.SpaceDto;
//import org.springframework.stereotype.Service;


public interface SpaceService {

    void delete(Long id);

    SpaceDto update(SpaceDto updatedSpace, Long id);

    SpaceDto create(SpaceDto newSpace);

    Object allspace();
}
