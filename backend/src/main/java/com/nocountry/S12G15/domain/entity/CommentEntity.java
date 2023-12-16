package com.nocountry.S12G15.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Data
public class CommentEntity {

    @Id
    @UuidGenerator
    private String idComment;

    private String text;

    @ManyToOne
    @JoinColumn(name = "idChannel")
    @JsonIgnore
    private ChannelEntity channelEntity;

    @ManyToOne
    @JoinColumn(name = "idUser")
    @JsonIgnore
    private UserEntity userEntity;

}
