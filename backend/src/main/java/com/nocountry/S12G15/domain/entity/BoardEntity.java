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
    private String boardName;
    private String description;

    @OneToMany
    private List<TaskEntity> tasks;

//    @OneToOne
//    protected ImageEntity imageEntity;

    private boolean enabled = true;
}
