package com.nocountry.S12G15.dto.response;


import java.io.Serial;
import java.io.Serializable;

public record UserResponseDTO(
        String id,
        String name,
        String lastName,
        String idBoard
)
        implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}
