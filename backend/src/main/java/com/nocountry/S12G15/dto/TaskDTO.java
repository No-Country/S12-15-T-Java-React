package com.nocountry.S12G15.dto;

import java.io.Serial;
import java.io.Serializable;

public record TaskDTO(
        String nameDTO,
        String descriptionDTO,
        String subTopicDTO
)
        implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}
