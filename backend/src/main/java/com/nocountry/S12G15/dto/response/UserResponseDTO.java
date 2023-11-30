package com.nocountry.S12G15.dto.response;


import com.nocountry.S12G15.domain.entity.SpaceEntity;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public record UserResponseDTO(
        String id,
        String name,
        String lastName,
        String idBoard,

        boolean disabled,

        List<SpaceEntity> spaceEntityList

)
        implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

}
