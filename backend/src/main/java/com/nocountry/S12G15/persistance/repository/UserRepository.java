package com.nocountry.S12G15.persistance.repository;

import com.nocountry.S12G15.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,String> {

    Optional<UserEntity> findUserByEmail(String email);
    Optional<UserEntity> findByEmailAndDisabledFalse(String email);
    List<UserEntity> findByDisabledFalse();
    List<UserEntity> findByDisabledTrue();

    Optional<UserEntity> findByIdAndDisabledFalse(String id);
}
