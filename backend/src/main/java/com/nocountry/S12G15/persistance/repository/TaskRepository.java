package com.nocountry.S12G15.persistance.repository;

import com.nocountry.S12G15.domain.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, String> {

    List<TaskEntity> saveAll(List<TaskEntity> entities);
}
