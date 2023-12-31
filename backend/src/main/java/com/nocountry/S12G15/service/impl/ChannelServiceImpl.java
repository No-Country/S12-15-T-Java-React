package com.nocountry.S12G15.service.impl;

import com.nocountry.S12G15.domain.entity.ChannelEntity;
import com.nocountry.S12G15.dto.request.ChannelRequestDTO;
import com.nocountry.S12G15.dto.response.ChannelResponseDTO;
import com.nocountry.S12G15.exception.ObjectNotFoundException;
import com.nocountry.S12G15.mapper.ChannelMapper;
import com.nocountry.S12G15.persistance.repository.ChannelRepository;
import com.nocountry.S12G15.service.ChannelService;
//import com.nocountry.S12G15.util.Utility;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class ChannelServiceImpl implements ChannelService {

    private final ChannelMapper mapper;
    private final ChannelRepository channelRepository;
    //private final Utility utility;

    @Override
    @Transactional
    public ChannelResponseDTO createChannel(ChannelRequestDTO data) {
        ChannelEntity channelSave = mapper.toGetChannelEntity(data);
        channelSave.setStatus(ChannelEntity.ChannelStatus.ENABLED);
        channelRepository.save(channelSave);
        return mapper.toGetChannelResponseDto(channelSave);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ChannelResponseDTO> findAll(Pageable pageable) {
        Page<ChannelEntity> channels = channelRepository.findAll(pageable);

        List<ChannelResponseDTO> responseDTOList = channels.getContent()
                .stream()
                .map(mapper::toGetChannelResponseDto)
                .toList();

        return new PageImpl<>(responseDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ChannelResponseDTO> findChannelById(String idChannel) {
        Function<String,Optional<ChannelEntity>> function= channelRepository::findById;
        ChannelEntity channelEntity = function.apply(idChannel)
                .orElseThrow(()-> new ObjectNotFoundException("No se encontro canal" + idChannel));
        return Optional.of(mapper.toGetChannelResponseDto(channelEntity));

    }

    @Override
    @Transactional
    public ChannelResponseDTO updateChannel(ChannelRequestDTO data, String idChannel) {
        Function<ChannelRequestDTO,Optional<ChannelEntity>> channelId= channelRequestDTO -> channelRepository.findById(idChannel);
        Optional<ChannelEntity> channelEntity = channelId.apply(data);
        if(channelEntity.isEmpty()){
            throw new ObjectNotFoundException("No se encontro canal con este id"+ idChannel);
        }
        ChannelEntity modifyChannel = channelEntity.get().modifyChannel(data);
        ChannelEntity saveChannel = channelRepository.save(modifyChannel);
        return mapper.toGetChannelResponseDto(saveChannel);
    }



    @Override
    public Optional<ChannelResponseDTO> findOneByIdBoard(String id, String id_board) {
        return Optional.empty();
    }

    @Override
    public Page<ChannelResponseDTO> findAllByIdBoard(String idBoard, Pageable pageable) {
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
