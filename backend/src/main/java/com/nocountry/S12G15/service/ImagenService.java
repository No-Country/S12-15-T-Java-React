package com.nocountry.S12G15.service;

import com.nocountry.S12G15.domain.entity.ImagenEntity;

import java.util.List;
import java.util.Optional;

public interface ImagenService {

    List<ImagenEntity> list();

    Optional<ImagenEntity> getImagen(Long fileId);

    void save(ImagenEntity imagen);

    boolean exists(Long id);

    void delete(Long id);
}
