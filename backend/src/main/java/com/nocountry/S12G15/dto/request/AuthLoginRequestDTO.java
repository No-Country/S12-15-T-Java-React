package com.nocountry.S12G15.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthLoginRequestDTO {
    private String email;

    private String password;
}
