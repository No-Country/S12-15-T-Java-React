package com.nocountry.S12G15.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ChannelEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    private String idChannel;

    private String type;

    private String topic;

    private String notes;

    @Enumerated(EnumType.STRING)
    private ChannelStatus status;

    @ManyToOne
    private BoardEntity boardEntity;
    public enum ChannelStatus{
        ENABLED, DISABLED;
    }
}
