package com.nocountry.S12G15.dto.request;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Builder
public class ChannelRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String nameChannel;



}
