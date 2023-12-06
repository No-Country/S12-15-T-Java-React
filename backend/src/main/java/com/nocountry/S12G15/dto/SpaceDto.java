package com.nocountry.S12G15.dto;

import com.nocountry.S12G15.domain.entity.BoardEntity;
import com.nocountry.S12G15.domain.entity.ChannelEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpaceDto implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;
    private String id;

    private String name;

    private String description;

    private String coverImage;

    private Date lastModified;

    private Date createdAt;

    private List<BoardEntity> boardEntityList;

    private List<ChannelEntity> ChannelEntityList;

}
