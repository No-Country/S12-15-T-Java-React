package com.nocountry.S12G15.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity
@Data
public class BoardEntity {
    @Id
    @UuidGenerator
    private String idBoard;
    private String boardName;
    private String description;

    @OneToMany
    private List<TaskEntity> tasks;

    private boolean enabled = true;
}
