package com.nocountry.S12G15.dto.request;

import com.nocountry.S12G15.enums.RolUser;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthRegisterRequestDTO {

    private String username;

    private String email;

    private String password;

    private String repeatedPassword;

    //private RolUser role;

}
