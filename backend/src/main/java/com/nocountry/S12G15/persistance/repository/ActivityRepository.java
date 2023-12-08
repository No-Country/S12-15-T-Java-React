package com.nocountry.S12G15.persistance.repository;

import com.nocountry.S12G15.domain.entity.ActivityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<ActivityEntity, String> {
}
