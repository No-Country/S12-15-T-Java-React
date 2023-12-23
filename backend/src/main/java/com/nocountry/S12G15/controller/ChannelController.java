package com.nocountry.S12G15.controller;

import com.nocountry.S12G15.domain.entity.ChannelEntity;
import com.nocountry.S12G15.domain.entity.CommentEntity;
import com.nocountry.S12G15.domain.entity.SpaceEntity;
import com.nocountry.S12G15.dto.request.ChannelRequestDTO;
import com.nocountry.S12G15.dto.response.ChannelResponseDTO;
import com.nocountry.S12G15.dto.response.ChatResponseDTO;
import com.nocountry.S12G15.dto.response.CommentResponseDTO;
import com.nocountry.S12G15.persistance.repository.ChannelRepository;
import com.nocountry.S12G15.persistance.repository.SpaceRepository;
import com.nocountry.S12G15.service.ChannelService;
import com.nocountry.S12G15.service.CommentService;
import com.nocountry.S12G15.service.ImageService;
import com.nocountry.S12G15.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.nocountry.S12G15.util.Constant.API_VERSION;
import static com.nocountry.S12G15.util.Constant.RESOURCE_CHANNEL;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = API_VERSION + RESOURCE_CHANNEL)
public class ChannelController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private ChannelService channelService;

    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    private SpaceService spaceService;
    @Autowired
    private SpaceRepository spaceRepository;

    @Autowired
    private CommentService commentService;


    @PostMapping("/new/{idSpace}")
    public ResponseEntity<?> createChannel(@RequestBody ChannelRequestDTO channelRequestDTO, @PathVariable String idSpace){

        SpaceEntity space = spaceRepository.findById(idSpace).orElse(null);

        if (channelRequestDTO.getNameChannel() == null || space == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }

        try{
            ChannelResponseDTO channelResponseDTO= channelService.createChannel(channelRequestDTO);
            String idChannel = channelResponseDTO.getIdChannel();
            spaceService.addChannelToSpace(idSpace, idChannel);
            return ResponseEntity.status(OK).body(channelResponseDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "}"));
        }

    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllChannels(Pageable pageable) {

        try {
            Page<ChannelResponseDTO> content = channelService.findAll(pageable);
            Map<String, Object> response = Map.of("message", "Listado de Canales", "data", content.get());
            return new ResponseEntity<>(response, OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "}"));
        }

    }

    @GetMapping("/{idChannel}")
    public ResponseEntity<?> getChannel(@PathVariable String idChannel){
        try {
            Optional<ChannelResponseDTO> channel = channelService.findChannelById(idChannel);
            return new ResponseEntity<>(channel,HttpStatus.OK);
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "}"));
        }
    }

    @PutMapping("/{idChannel}/disabled")
    public ResponseEntity<?> disabledChannelById(@PathVariable String idChannel){

        ChannelEntity channel = channelService.disabledOneById(idChannel);

        return ResponseEntity.ok(channel);
    }

    @PostMapping("/sendComment")
    public ResponseEntity<?> createText(
            @RequestParam String idUser,
            @RequestParam String idChannel,
            @RequestBody CommentEntity text) {

        CommentResponseDTO response = commentService.createComment(idUser, idChannel, text);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @GetMapping("/chat")
    public ResponseEntity<?> getChat(@RequestParam String idChannel){

        List<ChatResponseDTO> comments = commentService.getAllComments(idChannel);

        if (comments.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(comments);
    }
}
