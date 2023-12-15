package com.nocountry.S12G15.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface CloudinaryService {
    static Map delete(Object cloudinaryId) {
        return null;
    }

    Map upload(MultipartFile multipartFile) throws IOException;
}
