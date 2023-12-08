package com.nocountry.S12G15.service.impl;

import com.nocountry.S12G15.domain.entity.ChannelEntity;
import com.nocountry.S12G15.domain.entity.ImageEntity;
import com.nocountry.S12G15.persistance.repository.ChannelRepository;
import com.nocountry.S12G15.persistance.repository.ImageRepository;
import com.nocountry.S12G15.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ChannelRepository channelRepository;
    @Autowired
    ImageRepository imageRepository;
    @Override
    public ImageEntity saveImage(MultipartFile file, String idChannel) {

        ChannelEntity channelEntity = channelRepository.findById(idChannel).orElseThrow();

        try {
            ImageEntity imageEntity = new ImageEntity();
            imageEntity.setImageContent(file.getBytes());
            imageRepository.save(imageEntity);

            channelEntity.setImageEntity(imageEntity);
            channelRepository.save(channelEntity);

            return imageEntity;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public byte[] getPhoto(String idChannel) {

        ChannelEntity channel = channelRepository.findById(idChannel).orElseThrow();

        byte[] file = channel.getImageEntity().getImageContent();

        return file;




    }
}
