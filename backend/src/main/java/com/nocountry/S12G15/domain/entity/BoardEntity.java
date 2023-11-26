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
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idBoard;

    @Column(name = "description")
    private String description;
    @Column(name = "topic")
    private String topic;

    @Column(name = "notes")
    @OneToMany(mappedBy = "boardEntity")
    private List<NoteEntity> noteEntityStringList;

    @ManyToOne
    private UserEntity userEntity;
}
