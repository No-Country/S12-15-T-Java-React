package com.nocountry.S12G15.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.nocountry.S12G15.domain.entity.ChannelEntity;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

//@JsonPropertyOrder({"idChannel", "type", "topic", "notes"})
//@JsonRootName(value = "data")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChannelResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String idChannel;

    private String nameChannel;

    private ChannelEntity.ChannelStatus status;

}
