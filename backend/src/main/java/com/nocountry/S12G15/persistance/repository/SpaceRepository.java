package com.nocountry.S12G15.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nocountry.S12G15.domain.entity.SpaceEntity;
@Repository
public interface SpaceRepository extends JpaRepository<SpaceEntity, String> {

}
