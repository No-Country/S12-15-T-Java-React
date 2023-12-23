package com.nocountry.S12G15.dto.request;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthRegisterRequestDTO {

    private String name;

    private String lastName;

    private String username;

    private String email;

    private String password;

    private String repeatedPassword;

}
