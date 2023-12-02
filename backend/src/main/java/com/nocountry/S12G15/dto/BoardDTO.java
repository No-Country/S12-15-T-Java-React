package com.nocountry.S12G15.dto;

import com.nocountry.S12G15.domain.entity.TaskEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BoardDTO {

    private String idBoard;
    private String boardName;
    private String description;
    private List<TaskEntity> tasks;
    private boolean enabled;


}
