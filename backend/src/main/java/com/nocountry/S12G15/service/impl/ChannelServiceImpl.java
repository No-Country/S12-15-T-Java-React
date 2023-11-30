package com.nocountry.S12G15.service.impl;

import com.nocountry.S12G15.domain.entity.ChannelEntity;
import com.nocountry.S12G15.exception.ObjectNotFoundException;
import com.nocountry.S12G15.persistance.repository.ChannelRepository;
import com.nocountry.S12G15.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChannelServiceImpl implements ChannelService {

    @Autowired
    private ChannelRepository channelRepository;
    @Override
    public Page<ChannelEntity> findAll(Pageable pageable) {
        return channelRepository.findAll(pageable);
    }

    @Override
    public Optional<ChannelEntity> findChannelById(String idChannel) {
        return channelRepository.findById(idChannel);
    }

    @Override
    public ChannelEntity createChannel(ChannelEntity channelEntity) {
        return null;
    }

    @Override
    public ChannelEntity disabledOneById(String idChannel) {
        ChannelEntity channel = channelRepository.findById(idChannel)
                .orElseThrow( () -> new ObjectNotFoundException("Channel Not Found with id " +idChannel));

                channel.setStatus(ChannelEntity.ChannelStatus.DISABLED);

        return channelRepository.save(channel);

    }


}
