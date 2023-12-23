package com.nocountry.S12G15.service;


import com.nocountry.S12G15.domain.entity.CommentEntity;
import com.nocountry.S12G15.dto.response.ChatResponseDTO;
import com.nocountry.S12G15.dto.response.CommentResponseDTO;

import java.util.List;

public interface CommentService {

    CommentResponseDTO createComment(String idUser, String idChannel, CommentEntity text);

    List<ChatResponseDTO> getAllComments(String idChannel);
}
