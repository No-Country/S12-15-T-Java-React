package com.nocountry.S12G15.dto.response;

import com.nocountry.S12G15.domain.entity.CommentEntity;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ChatResponseDTO {

    private String idChannel;

    private String nameChannel;

    private String idUser;

    private String userName;

    private LocalDateTime localDateTime;

    private String comments;
}
