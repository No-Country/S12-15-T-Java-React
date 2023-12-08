package com.nocountry.S12G15.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Data
public class ActivityEntity {

    @Id
    @UuidGenerator
    private String idActivity;

    private String description;

    private boolean enabled;

}
