package com.nocountry.S12G15.controller.dto;
import com.nocountry.S12G15.domain.entity.ImageEntity;
import com.nocountry.S12G15.domain.entity.UserEntity;
import com.nocountry.S12G15.dto.BoardDTO;
import com.nocountry.S12G15.dto.request.SpaceRequestDTO;
import com.nocountry.S12G15.dto.response.ChannelResponseDTO;
import com.nocountry.S12G15.dto.response.SpaceResponseDTO;
import com.nocountry.S12G15.dto.response.UserResponseDTO;
import com.nocountry.S12G15.exception.MyException;
import com.nocountry.S12G15.persistance.repository.UserRepository;
import com.nocountry.S12G15.service.ImageService;
import com.nocountry.S12G15.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.nocountry.S12G15.service.SpaceService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static com.nocountry.S12G15.util.Constant.*;

@RestController
@RequestMapping(value = API_VERSION + RESOURCE_SPACE)
public class SpaceController {

    @Autowired
    private SpaceService spaceService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ImageService imageService;
    @Autowired
    private UserService userService;

    @PostMapping("/create/{idUser}")
    public ResponseEntity<SpaceResponseDTO> newSpace(@RequestBody SpaceRequestDTO spaceRequestDTO, @PathVariable String idUser) throws MyException {
        UserEntity user = userRepository.findById(idUser).orElse(null);

        if (spaceRequestDTO.getName() == null || user == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } else {
            SpaceResponseDTO spaceResponseDTO = spaceService.createSpace(spaceRequestDTO);
            String idSpace = spaceResponseDTO.getIdSpace();
            userService.addSpaceToUser(idUser, idSpace);
            return ResponseEntity.status(HttpStatus.CREATED).body(spaceResponseDTO);
        }
    }

    @GetMapping("/listOfSpaces")
    public ResponseEntity<List<SpaceResponseDTO>> getAllSpaces() {
        List<SpaceResponseDTO> spacesResponseDTO = spaceService.getEnabledSpaces();

        if (spacesResponseDTO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(spacesResponseDTO);
    }

    @GetMapping("/listOfEnabledBoardsByIdSpace/{idSpace}")
    public ResponseEntity<List<BoardDTO>> getAllEnabledBoardsByIdSpace(@PathVariable String idSpace) {
        List<BoardDTO> boardsDTO = spaceService.getAllEnabledBoards(idSpace);

        if (boardsDTO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(boardsDTO);
    }

    @GetMapping("/listOfEnabledChannelsByIdSpace/{idSpace}")
    public ResponseEntity<List<ChannelResponseDTO>> getAllEnabledChannelsByIdSpace(@PathVariable String idSpace) {
        List<ChannelResponseDTO> channelsResponseDTO = spaceService.getAllEnabledChannels(idSpace);

        if (channelsResponseDTO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(channelsResponseDTO);
    }




    @GetMapping("/{idSpace}")
    public ResponseEntity<SpaceResponseDTO> findSpaceById(@PathVariable String idSpace) {
        SpaceResponseDTO spaceResponseDTO = spaceService.findSpaceById(idSpace);

        if (spaceResponseDTO != null) {
            return ResponseEntity.status(HttpStatus.OK).body(spaceResponseDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/update/{idSpace}")
    public ResponseEntity<SpaceResponseDTO> updateSpace(@PathVariable String idSpace, @RequestBody SpaceRequestDTO updatedSpaceDTO) throws MyException{
        SpaceResponseDTO spaceResponseDTO = spaceService.findSpaceById(idSpace);
        spaceService.updateSpace(idSpace, updatedSpaceDTO);

        if (updatedSpaceDTO.getName() == null || spaceResponseDTO == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }

        return ResponseEntity.status(HttpStatus.OK).body(spaceResponseDTO);
    }

    // Eliminando por ID
    @PutMapping("/disable/{idSpace}")
    public ResponseEntity<SpaceResponseDTO> disableSpace(@PathVariable String idSpace) {
        SpaceResponseDTO spaceResponseDTO = spaceService.findSpaceById(idSpace);
        SpaceResponseDTO disabledSpaceResponseDTO = spaceService.disableSpace(idSpace);

        if (spaceResponseDTO != null) {
            return ResponseEntity.status(HttpStatus.OK).body(disabledSpaceResponseDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/enable/{idSpace}")
    public ResponseEntity<SpaceResponseDTO> enableSpace(@PathVariable String idSpace) {
        SpaceResponseDTO spaceResponseDTO = spaceService.findSpaceById(idSpace);
        SpaceResponseDTO disabledSpaceResponseDTO = spaceService.enableSpace(idSpace);

        if (spaceResponseDTO != null) {
            return ResponseEntity.status(HttpStatus.OK).body(disabledSpaceResponseDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/uploadPhoto")
    public ResponseEntity<?> uploadPhoto (@RequestParam MultipartFile file, @RequestParam String idSpace) {

        ImageEntity imageEntity = imageService.saveImageSpace(file, idSpace);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/v1/api/space/getPhoto")
                .queryParam("idSpace", idSpace)
                .build()
                .toUri();

        return ResponseEntity.status(HttpStatus.CREATED).body(uri);
    }

    @GetMapping("/getPhoto")
    public ResponseEntity<byte[]> getPhoto(@RequestParam String idSpace){

        byte[] image = imageService.getPhoto(idSpace);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);

        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(image);
    }

    @PutMapping("/{userEmail}/addSpace/{idSpace}")
    public ResponseEntity<?> addSpaceToUserFromEmail(@PathVariable String userEmail, @PathVariable String idSpace){
        Optional<UserResponseDTO> userResponseDTO = userService.getEnabledUserByEmail(userEmail);
        if(userResponseDTO.isEmpty()){
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        Optional<SpaceResponseDTO> spaceResponseDTO = userService.getEnabledSpaceById(idSpace);
        if(spaceResponseDTO.isEmpty()){
            return new ResponseEntity<>("Space not found", HttpStatus.NOT_FOUND);
        }
        UserResponseDTO userResponseDTOSaved = userService.addSpaceToUser(userResponseDTO.get().getId(), idSpace);

        return new ResponseEntity<>(userResponseDTOSaved, HttpStatus.OK);
    }
}