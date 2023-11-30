package com.nocountry.S12G15.dto.request;

import com.nocountry.S12G15.domain.entity.SpaceEntity;
import com.nocountry.S12G15.enums.RolUser;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Builder
@Data
public class UserRequestDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private boolean disabled;

    private String name;

    private String lastName;

    private String email;

    private RolUser rolUser;

    private List<SpaceEntity> spaceEntityList;

}
