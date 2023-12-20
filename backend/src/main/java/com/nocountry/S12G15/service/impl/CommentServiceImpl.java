package com.nocountry.S12G15.service.impl;

import com.nocountry.S12G15.domain.entity.ChannelEntity;
import com.nocountry.S12G15.domain.entity.CommentEntity;
import com.nocountry.S12G15.domain.entity.ImageEntity;
import com.nocountry.S12G15.domain.entity.UserEntity;
import com.nocountry.S12G15.dto.response.ChatResponseDTO;
import com.nocountry.S12G15.dto.response.CommentResponseDTO;
import com.nocountry.S12G15.persistance.repository.ChannelRepository;
import com.nocountry.S12G15.persistance.repository.CommentRepository;
import com.nocountry.S12G15.persistance.repository.UserRepository;
import com.nocountry.S12G15.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private ChannelRepository channelRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public CommentResponseDTO createComment(String idUser, String idChannel, CommentEntity text) {

        UserEntity userEntity = userRepository.findById(idUser).orElseThrow();

        ChannelEntity channelEntity = channelRepository.findById(idChannel).orElseThrow();

        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setText(text.getText());
        commentEntity.setLocalDateTime(LocalDateTime.now());
        commentEntity.setUserEntity(userEntity);
        commentEntity.setChannelEntity(channelEntity);
        commentRepository.save(commentEntity);

        CommentResponseDTO response = new CommentResponseDTO();
        response.setNameChannel(commentEntity.getChannelEntity().getNameChannel());
        response.setUserName(commentEntity.getUserEntity().getRealUserName());
        response.setComment(commentEntity.getText());
        response.setLocalDateTime(commentEntity.getLocalDateTime());

        return response;
    }

    @Override
    public List<ChatResponseDTO> getAllComments(String idChannel) {

        List<CommentEntity> comments = commentRepository.findAllComments(idChannel);

        List<ChatResponseDTO> commentsDTO = new ArrayList<>();

        for (CommentEntity c : comments) {

            ChatResponseDTO chatDTO = new ChatResponseDTO();

            //if(c.getChannelEntity().getIdChannel().equals(idChannel)) {
                chatDTO.setIdUser(c.getUserEntity().getId());
                chatDTO.setUserName(c.getUserEntity().getUsername());
                if(c.getUserEntity().getImageEntity() == null){
                    ImageEntity im = new ImageEntity();
                    im.setIdImage("No Image");
                    chatDTO.setIdImage(im.getIdImage());
                }else{
                    chatDTO.setIdImage(c.getUserEntity().getImageEntity().getIdImage());
                }

                chatDTO.setIdChannel(c.getChannelEntity().getIdChannel());
                chatDTO.setNameChannel(c.getChannelEntity().getNameChannel());
                chatDTO.setLocalDateTime(c.getLocalDateTime());
                chatDTO.setComments(c.getText());
                commentsDTO.add(chatDTO);
            //}
        }

        return commentsDTO;

    }
}
