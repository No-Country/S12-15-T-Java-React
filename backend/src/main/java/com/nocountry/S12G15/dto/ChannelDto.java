package com.nocountry.S12G15.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

//deprecated
public class ChannelDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String idChannel;

    private String type;

    private String topic;

    private String notes;

    private enum ChannelStatus{
        ENABLED, DISABLED;
    }

}
