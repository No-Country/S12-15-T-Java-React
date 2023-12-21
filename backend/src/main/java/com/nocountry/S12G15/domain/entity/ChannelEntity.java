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

    private String nameChannel;

    @Enumerated(EnumType.STRING)
    private ChannelStatus status;

    @OneToOne
    protected ImageEntity imageEntity;
    public enum ChannelStatus{
        ENABLED, DISABLED;
    }
    public ChannelEntity modifyChannel(ChannelRequestDTO requestDTO){
        if(requestDTO.getNameChannel() != null || !requestDTO.getNameChannel().isEmpty())this.setNameChannel(requestDTO.getNameChannel().strip());

        return this;
    }
}
