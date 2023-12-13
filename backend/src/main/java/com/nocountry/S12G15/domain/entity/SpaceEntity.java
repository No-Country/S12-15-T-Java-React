package com.nocountry.S12G15.domain.entity;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.UuidGenerator;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

//import org.hibernate.annotations.GenericGenerator;
@Entity
@Data
public class SpaceEntity {
    @Id
    @UuidGenerator
    private String idSpace;
    private String name;
    private String description;

    @OneToOne
    protected ImageEntity imageEntity;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate createdAt;
    private boolean enabled;
    @OneToMany
    private List<BoardEntity> boards;
    @OneToMany
    private List<ChannelEntity> channels;


}