package com.nocountry.S12G15.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ActivityDTO {

    private String idActivity;
    private String description;
    private String name;
    private String username;

    private boolean enabled;
}
