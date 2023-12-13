package com.nocountry.S12G15.service.impl;

import com.nocountry.S12G15.domain.entity.ChannelEntity;
import com.nocountry.S12G15.domain.entity.ImageEntity;
import com.nocountry.S12G15.domain.entity.SpaceEntity;
import com.nocountry.S12G15.persistance.repository.ChannelRepository;
import com.nocountry.S12G15.persistance.repository.ImageRepository;
import com.nocountry.S12G15.persistance.repository.SpaceRepository;
import com.nocountry.S12G15.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    SpaceRepository spaceRepository;
    @Autowired
    ImageRepository imageRepository;
    @Override
    public ImageEntity saveImageSpace(MultipartFile file, String idSpace) {

        SpaceEntity space = spaceRepository.findById(idSpace).orElseThrow();

        try {
            ImageEntity imageEntity = new ImageEntity();
            imageEntity.setImageContent(file.getBytes());
            imageRepository.save(imageEntity);

            space.setImageEntity(imageEntity);
            spaceRepository.save(space);

            return imageEntity;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public byte[] getPhoto(String idChannel) {

        SpaceEntity space = spaceRepository.findById(idChannel).orElseThrow();

        byte[] file = space.getImageEntity().getImageContent();

        return file;




    }
}
