package com.nocountry.S12G15.controller.dto;

import com.nocountry.S12G15.domain.entity.ChannelEntity;
import com.nocountry.S12G15.dto.request.ChannelRequestDTO;
import com.nocountry.S12G15.dto.request.PageableDto;
import com.nocountry.S12G15.dto.response.ChannelResponseDTO;
import com.nocountry.S12G15.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

import static com.nocountry.S12G15.util.Constant.API_VERSION;
import static com.nocountry.S12G15.util.Constant.RESOURCE_CHANNEL;
import static org.springframework.http.HttpStatus.OK;


@RestController
@RequestMapping(value = API_VERSION + RESOURCE_CHANNEL)
public class ChannelController {

    @Autowired
    private ChannelService channelService;
    /*
    * NewChannel
    * http://localhost:8080/v1/api/channel/new
    * body: {
    "type":"SomeOneMore",
    "topic":"ForAll",
    "notes":"This'sAnNote"
    }
    * */
    public ResponseEntity<?> createChannel(@RequestBody ChannelRequestDTO channelRequestDTO){
        try{
            ChannelResponseDTO channelResponseDTO= channelService.createChannel(channelRequestDTO);
            return ResponseEntity.status(OK).body(channelResponseDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "}"));
        }

    }
    /*
    GetAll
    http://localhost:8080/v1/api/channel/all?page=0&size=4&order=1&field=idChannel
    * */
    @GetMapping("/all")
    public ResponseEntity<?> getAllChannels(PageableDto pageableDto){

        try{
            Page<ChannelResponseDTO> content = channelService.findAll(pageableDto);
            Map<String,Object> response = Map.of("message","Listado de Canales","data",content.get());
            return new ResponseEntity<>(response, OK);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "}"));
        }

    }
    /*GetById
    http://localhost:8080/v1/api/channel/95bae2b8-f02d-4fee-a52f-c6d60319195b
    * */
    @GetMapping("/{idChannel}")
    public ResponseEntity<?> getChannel(@PathVariable String idChannel){
        try {
            Optional<ChannelResponseDTO> channel = channelService.findChannelById(idChannel);
            return new ResponseEntity<>(channel,HttpStatus.OK);
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "}"));
        }
    }
    /*
    * DisabledChannel
    * http://localhost:8080/v1/api/channel/95bae2b8-f02d-4fee-a52f-c6d60319195b/disabled
    * */
    @PutMapping("/{idChannel}/disabled")
    public ResponseEntity<?> disabledChannelById(@PathVariable String idChannel){

        ChannelEntity channel = channelService.disabledOneById(idChannel);

        return ResponseEntity.ok(channel);
    }
}
