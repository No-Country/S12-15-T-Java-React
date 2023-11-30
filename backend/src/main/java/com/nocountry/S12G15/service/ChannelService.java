package com.nocountry.S12G15.service;

import com.nocountry.S12G15.domain.entity.ChannelEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ChannelService {

    Page<ChannelEntity> findAll(Pageable pageable);
    Optional<ChannelEntity> findChannelById(String idChannel);//debe devolver un channel dto
    ChannelEntity createChannel(ChannelEntity channelEntity);//debe recibir un channeldto
    ChannelEntity disabledOneById(String idChannel);



}
