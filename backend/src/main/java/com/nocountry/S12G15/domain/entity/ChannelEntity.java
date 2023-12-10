package com.nocountry.S12G15.domain.entity;

import com.nocountry.S12G15.dto.request.ChannelRequestDTO;
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

    @OneToOne
    protected ImageEntity imageEntity;
    public enum ChannelStatus{
        ENABLED, DISABLED;
    }
    public ChannelEntity modifyChannel(ChannelRequestDTO requestDTO){
        if(requestDTO.getType() != null || !requestDTO.getType().isEmpty())this.setType(requestDTO.getType().strip());
        if(requestDTO.getTopic() != null || !requestDTO.getTopic().isEmpty())this.setTopic(requestDTO.getTopic().strip());
        return this;
    }
}
