package com.nocountry.S12G15.dto.response;


//import com.nocountry.S12G15.domain.entity.SpaceEntity;

import com.nocountry.S12G15.domain.entity.ImageEntity;
import com.nocountry.S12G15.domain.entity.SpaceEntity;
import com.nocountry.S12G15.enums.RolUser;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
@Data
public class UserResponseDTO {
    private String id;

    private boolean disabled=true;

    private String name;


    private String lastName;


    private String email;


    private String username;


    @Enumerated(EnumType.STRING)
    private RolUser rolUser;




    private String description;

    @OneToOne
    protected ImageEntity imageEntity;


    @OneToMany
    private List<SpaceEntity> spaceEntityList;


}

/*
public record UserResponseDTO(
        String id,
        String name,
        String lastName,
        String idBoard,
        String username,
        boolean disabled

        //List<SpaceEntity> spaceEntityList

)
        implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

}
*/