package com.nocountry.S12G15.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String name;

    private String description;
}
