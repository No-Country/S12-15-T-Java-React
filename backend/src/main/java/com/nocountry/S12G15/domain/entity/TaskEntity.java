package com.nocountry.S12G15.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class TaskEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    private String idTask;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

//    @ManyToOne
//    private List<Permission> permissions;

    public enum TaskStatus{
        ENABLED, DISABLED;
    }

}
