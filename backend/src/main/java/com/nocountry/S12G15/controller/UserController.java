package com.nocountry.S12G15.controller;

import com.nocountry.S12G15.domain.entity.ImageEntity;
import com.nocountry.S12G15.dto.response.SpaceResponseDTO;
import com.nocountry.S12G15.dto.response.UserResponseDTO;
import com.nocountry.S12G15.service.ImageService;
import com.nocountry.S12G15.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static com.nocountry.S12G15.util.Constant.*;

@RestController
@RequestMapping(value = API_VERSION + RESOURCE_USER)
public class UserController {

    private final UserService userService;

    @Autowired
    private ImageService imageService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/getallusers")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers(){
        List<UserResponseDTO> userResponseDTOList = userService.getAllUsers();
        if(userResponseDTOList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userResponseDTOList, HttpStatus.OK);
    }
    @GetMapping("/getallenabledusers")
    public ResponseEntity<List<UserResponseDTO>> getAllEnabledUsers(){
        List<UserResponseDTO> userResponseDTOList = userService.getAllEnabledUsers();
        if(userResponseDTOList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userResponseDTOList, HttpStatus.OK);
    }
    @GetMapping("/getuserbyid/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id){
        Optional<UserResponseDTO> userResponseDTO = userService.getUserById(id);
        if(userResponseDTO.isEmpty()){
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userResponseDTO, HttpStatus.OK);
    }
    @GetMapping("/getenableduserbyid/{id}")
    public ResponseEntity<?> getEnabledUserById(@PathVariable String id){
        Optional<UserResponseDTO> userResponseDTO = userService.getEnabledUserById(id);
        if(userResponseDTO.isEmpty()){
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userResponseDTO.get(), HttpStatus.OK);
    }

    @PutMapping("/disableuserbyid/{id}")
    public ResponseEntity<Void> disableUserById(@PathVariable String id){
        userService.disableUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("/enableuserbyid/{id}")
    public ResponseEntity<Void> enableUserById(@PathVariable String id){
        userService.enableUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getuserbyemail/{email}")
    public ResponseEntity<UserResponseDTO> getUserByEmail(@PathVariable String email){
        Optional<UserResponseDTO> userResponseDTO = userService.getUserByEmail(email);
        if(userResponseDTO.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userResponseDTO.get(), HttpStatus.OK);
    }
    @GetMapping("/getenableduserbyemail/{email}")
    public ResponseEntity<?> getEnabledUserByEmail(@PathVariable String email){
        Optional<UserResponseDTO> userResponseDTO = userService.getEnabledUserByEmail(email);
        if(userResponseDTO.isEmpty()){
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userResponseDTO.get(), HttpStatus.OK);
    }

    @GetMapping("/getallspacesfromenableduserid/{userId}")
    public ResponseEntity<?> getAllSpacesFromEnabledUserID(@PathVariable String userId){
        Optional<UserResponseDTO> userResponseDTO = userService.getEnabledUserById(userId);
        if(userResponseDTO.isEmpty()){
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        List<SpaceResponseDTO> spaceResponseDTOList = userService.getAllSpaces(userId);
        if(spaceResponseDTOList.isEmpty()){
            return new ResponseEntity<>("No spaces found for the user", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(spaceResponseDTOList, HttpStatus.OK);

    }
    @GetMapping("/getallenabledspacesfromenableduserid/{userId}")
    public ResponseEntity<?> getAllEnabledSpacesFromEnabledUserID(@PathVariable String userId){
        Optional<UserResponseDTO> userResponseDTO = userService.getEnabledUserById(userId);
        if(userResponseDTO.isEmpty()){
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        List<SpaceResponseDTO> spaceResponseDTOList = userService.getAllEnabledSpaces(userId);
        if(spaceResponseDTOList.isEmpty()){
            return new ResponseEntity<>("No spaces found for the user", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(spaceResponseDTOList, HttpStatus.OK);

    }

    @PostMapping("/uploadPhoto")
    public ResponseEntity<?> uploadPhoto (@RequestParam MultipartFile file, @RequestParam String idUser) {

        ImageEntity imageEntity = imageService.saveImageUser(file, idUser);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/v1/api/users/getPhoto")
                .queryParam("idUser", idUser)
                .build()
                .toUri();

        return ResponseEntity.status(HttpStatus.CREATED).body(uri);
    }

    @GetMapping("/getPhoto")
    public ResponseEntity<byte[]> getPhoto(@RequestParam String idUser){

        byte[] image = imageService.getPhotoUser(idUser);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);

        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(image);
    }
}
