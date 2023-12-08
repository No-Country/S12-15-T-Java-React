package com.nocountry.S12G15.domain.entity;

import com.nocountry.S12G15.dto.request.TaskRequestDTO;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity
@Data
public class TaskEntity {
    @Id
    @UuidGenerator
    private String idTask;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    public enum TaskStatus{
        ENABLED, DISABLED
    }

    @OneToMany
    private List<ActivityEntity> activities;

    public TaskEntity updateTask(TaskRequestDTO taskReqDTO){
        if(taskReqDTO.getName()!= null || !taskReqDTO.getName().isEmpty())this.setName(taskReqDTO.getName().strip());
        if(taskReqDTO.getDescription()!= null || !taskReqDTO.getDescription().isEmpty())this.setDescription(taskReqDTO.getDescription().strip());
        return this;
    }

}
