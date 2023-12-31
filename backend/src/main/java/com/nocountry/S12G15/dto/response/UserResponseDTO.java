package com.nocountry.S12G15.dto.response;

import com.nocountry.S12G15.domain.entity.ImageEntity;
import com.nocountry.S12G15.domain.entity.SpaceEntity;
import lombok.Data;

import java.util.List;

@Data
public class UserResponseDTO {

    private String id;
    private String name;
    private String lastName;
    private boolean disabled;
    private List<SpaceEntity> spaceEntityList;
    private ImageEntity imageEntity;
}

