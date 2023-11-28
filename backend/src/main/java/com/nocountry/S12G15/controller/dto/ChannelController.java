package com.nocountry.S12G15.controller.dto;

import com.nocountry.S12G15.domain.entity.ChannelEntity;
import com.nocountry.S12G15.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.channels.Channel;
import java.util.Optional;

import static com.nocountry.S12G15.util.Constant.API_VERSION;
import static com.nocountry.S12G15.util.Constant.RESOURCE_CHANNEL;


@RestController
@RequestMapping(value = API_VERSION + RESOURCE_CHANNEL)
public class ChannelController {

    @Autowired
    private ChannelService channelService;

    @GetMapping
    public ResponseEntity<Page<ChannelEntity>> getAllChannels(Pageable pageable){

        Page<ChannelEntity> channelsPage = channelService.findAll(pageable);

        if(channelsPage.hasContent()){

            return ResponseEntity.ok(channelsPage);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @GetMapping("/{idChannel}")
    public ResponseEntity<?> getChannel(@PathVariable String idChannel){

        Optional<ChannelEntity> channel = channelService.findChannelById(idChannel);

        if(channel.isPresent()){

            return ResponseEntity.ok(channel.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/{idChannel}/disabled")
    public ResponseEntity<?> disabledChannelById(@PathVariable String idChannel){

        ChannelEntity channel = channelService.disabledOneById(idChannel);

        return ResponseEntity.ok(channel);
    }
}
