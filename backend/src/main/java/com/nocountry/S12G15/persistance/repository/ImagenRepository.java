package com.nocountry.S12G15.persistance.repository;

import com.nocountry.S12G15.domain.entity.ImagenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImagenRepository extends JpaRepository<ImagenEntity, Long> {
    List<ImagenEntity> findByOrderById();

    @Override
    Optional<ImagenEntity>findById(Long id);
}
