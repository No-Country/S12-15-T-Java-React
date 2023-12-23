package com.nocountry.S12G15.service.impl;

import com.nocountry.S12G15.domain.entity.ImageEntity;
import com.nocountry.S12G15.domain.entity.SpaceEntity;
import com.nocountry.S12G15.domain.entity.UserEntity;
import com.nocountry.S12G15.persistance.repository.ImageRepository;
import com.nocountry.S12G15.persistance.repository.SpaceRepository;
import com.nocountry.S12G15.persistance.repository.UserRepository;
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
    @Autowired
    UserRepository userRepository;

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
    public byte[] getPhotoSpace(String idChannel) {

        SpaceEntity space = spaceRepository.findById(idChannel).orElseThrow();

        byte[] file = space.getImageEntity().getImageContent();

        return file;
    }

    @Override
    public ImageEntity saveImageUser(MultipartFile file, String idUser) {

        UserEntity user = userRepository.findById(idUser).orElseThrow();

        try {
            ImageEntity imageEntity = new ImageEntity();
            imageEntity.setImageContent(file.getBytes());
            imageRepository.save(imageEntity);

            user.setImageEntity(imageEntity);
            userRepository.save(user);

            return imageEntity;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public byte[] getPhotoUser(String idUser) {

        UserEntity user = userRepository.findById(idUser).orElseThrow();

        byte[] file = user.getImageEntity().getImageContent();

        return file;
    }
}
