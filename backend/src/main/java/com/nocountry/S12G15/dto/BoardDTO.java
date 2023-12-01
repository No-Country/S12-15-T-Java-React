package com.nocountry.S12G15.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BoardDTO {

    private String idBoard;
    private String description;
    //private List<TaskEntity> tasks;
    private boolean enabled;


}
