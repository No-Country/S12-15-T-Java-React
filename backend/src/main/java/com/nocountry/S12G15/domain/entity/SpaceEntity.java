package com.nocountry.S12G15.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class SpaceEntity {
    @Id
    private Long id;

    private String name;

}
