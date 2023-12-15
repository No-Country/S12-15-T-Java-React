package com.nocountry.S12G15.service.impl;

import com.nocountry.S12G15.domain.entity.ImagenEntity;
import com.nocountry.S12G15.persistance.repository.ImagenRepository;
import com.nocountry.S12G15.service.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ImagenServiceImpl implements ImagenService {
    @Autowired
    ImagenRepository imagenRepository;

    public Optional<ImagenEntity> getImagen(Long id){
        return imagenRepository.findById(id);
    }

    public void save(ImagenEntity imagen){
        imagenRepository.save(imagen);
    }

    public void delete(Long id){
        imagenRepository.deleteById(id);
    }

    public boolean exists(Long id){
        return imagenRepository.existsById(id);
    }

    public List<ImagenEntity> list(){
        return imagenRepository.findByOrderById();
    }

}
