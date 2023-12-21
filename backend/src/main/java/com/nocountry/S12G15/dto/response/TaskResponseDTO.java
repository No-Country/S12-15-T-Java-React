package com.nocountry.S12G15.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String idTask;

    private String name;

    private String description;

    private boolean enabled;
}
