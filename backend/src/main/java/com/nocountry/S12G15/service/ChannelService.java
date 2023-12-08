package com.nocountry.S12G15.service;

import com.nocountry.S12G15.domain.entity.ChannelEntity;
import com.nocountry.S12G15.dto.request.ChannelRequestDTO;
import com.nocountry.S12G15.dto.request.PageableDto;
import com.nocountry.S12G15.dto.response.ChannelResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ChannelService {

    ChannelResponseDTO createChannel(ChannelRequestDTO data);//debe recibir un channeldto
    Page<ChannelResponseDTO> findAll(Pageable pageable);
    Optional<ChannelResponseDTO> findChannelById(String idChannel);//debe devolver un channel dto

    ChannelResponseDTO updateChannel(ChannelRequestDTO data,String idChannel);
    Optional<ChannelResponseDTO> findOneByIdBoard(String id,String id_board);
    Page<ChannelResponseDTO> findAllByIdBoard(String idBoard,Pageable pageable);

    ChannelEntity disabledOneById(String idChannel);



}
