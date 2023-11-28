package com.nocountry.S12G15.domain.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class TaskEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    private String taskId;

    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "subTopic")
    private String subTopic;

//    @ManyToOne
//    private List<Permission> permissions;

}
