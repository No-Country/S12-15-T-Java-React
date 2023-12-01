package com.nocountry.S12G15.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Data
public class BoardEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String idBoard;
    private String description;

    /*
    @OneToMany
    private List<TaskEntity> tasks;
    */

    private boolean enabled = true;
}
