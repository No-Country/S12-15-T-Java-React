package com.nocountry.S12G15.dto.response;

import com.nocountry.S12G15.domain.entity.BoardEntity;
import com.nocountry.S12G15.domain.entity.ChannelEntity;
import com.nocountry.S12G15.domain.entity.ImageEntity;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class SpaceResponseDTO {

    private String idSpace;
    private String name;
    private String description;
    private LocalDate createdAt;
    private ImageEntity imageEntity;
    private List<BoardEntity> boards;
    private List<ChannelEntity> channels;
    private boolean enabled;
}
