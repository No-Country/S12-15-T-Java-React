package com.nocountry.S12G15.service;

import com.nocountry.S12G15.domain.entity.ImageEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    public ImageEntity saveImageSpace(MultipartFile file, String idChannel);
    byte[] getPhotoSpace(String idChannel);

    public ImageEntity saveImageUser(MultipartFile file, String idUser);
    byte[] getPhotoUser(String idUser);
}
