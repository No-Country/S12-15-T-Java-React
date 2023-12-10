package com.nocountry.S12G15.service;

import com.nocountry.S12G15.domain.entity.ImageEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    public ImageEntity saveImage(MultipartFile file, String idChannel);

    byte[] getPhoto(String idChannel);
}
