package com.nocountry.S12G15.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String idTask;

    private String nameDTO;

    private String descriptionDTO;

}
