package com.nocountry.S12G15.dto.response;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ChatResponseDTO {

    private String idChannel;

    private String nameChannel;

    private String idUser;

    private String userName;

    private LocalDateTime localDateTime;

    private String comments;

    private String idImage;


}
