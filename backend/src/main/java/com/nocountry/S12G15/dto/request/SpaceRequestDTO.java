package com.nocountry.S12G15.dto.request;

import com.nocountry.S12G15.domain.entity.BoardEntity;
import com.nocountry.S12G15.domain.entity.ChannelEntity;
import com.nocountry.S12G15.domain.entity.ImageEntity;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Builder
@Getter @Setter
public class SpaceRequestDTO {
    private String name;
    private String description;
    protected ImageEntity imageEntity;
    private LocalDate createdAt;
    private List<BoardEntity> boards;
    private List<ChannelEntity> channels;
}
