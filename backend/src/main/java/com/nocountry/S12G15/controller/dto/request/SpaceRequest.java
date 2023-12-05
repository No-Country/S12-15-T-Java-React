package com.nocountry.S12G15.controller.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Builder
@Getter @Setter
public class SpaceRequest {
    public String name;
    public String description;
}
