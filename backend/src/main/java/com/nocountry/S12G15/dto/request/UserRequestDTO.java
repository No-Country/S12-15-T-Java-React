package com.nocountry.S12G15.dto.request;

import com.nocountry.S12G15.enums.RolUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class UserRequestDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String name;

    private String lastName;

    private String email;

    private RolUser rolUser;
}
