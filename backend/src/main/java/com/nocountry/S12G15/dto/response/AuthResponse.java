package com.nocountry.S12G15.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthResponse {

    private String token;
    private String id;
    private String name;
    private String lastName;
    private String idBoard;
}
