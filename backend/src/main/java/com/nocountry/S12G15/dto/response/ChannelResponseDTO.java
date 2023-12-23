package com.nocountry.S12G15.dto.response;

import com.nocountry.S12G15.domain.entity.ChannelEntity;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChannelResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String idChannel;

    private String nameChannel;

    private ChannelEntity.ChannelStatus status;

}
