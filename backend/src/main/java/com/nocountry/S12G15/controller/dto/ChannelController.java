package com.nocountry.S12G15.controller.dto;

import com.nocountry.S12G15.domain.entity.ChannelEntity;
import com.nocountry.S12G15.domain.entity.CommentEntity;
import com.nocountry.S12G15.domain.entity.ImageEntity;
import com.nocountry.S12G15.domain.entity.SpaceEntity;
import com.nocountry.S12G15.dto.BoardDTO;
import com.nocountry.S12G15.dto.request.ChannelRequestDTO;
import com.nocountry.S12G15.dto.request.PageableDto;
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

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.nio.channels.Channel;
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


    /*
    * NewChannel
    * http://localhost:8080/v1/api/channel/new
    * body: {
    "type":"SomeOneMore",
    "topic":"ForAll",
    "notes":"This'sAnNote"
    }
    * */
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
    /*
    GetAll
    http://localhost:8080/v1/api/channel/all?page=0&size=4&order=1&field=idChannel
    * */
    @GetMapping("/all")
    public ResponseEntity<?> getAllChannels(Pageable pageable){

        try{
            Page<ChannelResponseDTO> content = channelService.findAll(pageable);
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



//    @PostMapping("/upload")
//    public ResponseEntity<?> upLoadPhoto (@RequestParam MultipartFile file, @RequestParam String idChannel){
//
//        ImageEntity imageEntity = imageService.saveImage(file, idChannel);
//
//        URI uri = ServletUriComponentsBuilder
//                .fromCurrentContextPath()
//                .path("/v1/api/channel/getPhoto")
//                .queryParam("idChannel", idChannel)
//                .build()
//                .toUri();
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(uri);
//
//    }

//    @GetMapping("/getPhoto")
//    public ResponseEntity<byte[]> getPhoto(@RequestParam String idChannel){
//
//        byte[] image = imageService.getPhoto(idChannel);
//
//        HttpHeaders headers = new HttpHeaders();
//
//        headers.setContentType(MediaType.IMAGE_JPEG);
//
//        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(image);
//    }
}
