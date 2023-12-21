package com.nocountry.S12G15.dto.response;

import com.nocountry.S12G15.enums.RolUser;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthResponseDTO {

    private String token;
    private String email;
    private String id;
    private String name;
    private String lastName;
    private String userName;
    //private String idBoard;
    private RolUser rol;
}
