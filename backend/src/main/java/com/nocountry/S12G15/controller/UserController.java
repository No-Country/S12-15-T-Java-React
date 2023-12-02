package com.nocountry.S12G15.controller;

import com.nocountry.S12G15.dto.request.UserRequestDTO;
//import com.nocountry.S12G15.dto.response.SpaceResponseDTO;
import com.nocountry.S12G15.dto.response.UserResponseDTO;
//import com.nocountry.S12G15.service.SpaceService;
import com.nocountry.S12G15.service.UserService;
import com.nocountry.S12G15.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.nocountry.S12G15.util.Constant.*;

@RestController
@RequestMapping(value = API_VERSION + RESOURCE_USER)
public class UserController {

    private final UserService userService;



    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping("/all")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers(){
        List<UserResponseDTO> userResponseDTOList = userService.getAllUsers();
        return ResponseEntity.ok(userResponseDTOList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable String id){
        UserResponseDTO userResponseDTO = userService.getUserById(id);
        return new ResponseEntity<>(userResponseDTO, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userRequestDTO){
        UserResponseDTO userResponseDTO1 = userService.createUser(userRequestDTO);
        return new ResponseEntity<>(userResponseDTO1, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}/disable")
    public ResponseEntity<Void> disableUser(@PathVariable String id){
        userService.disableUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}/enable")
    public ResponseEntity<Void> enableUser(@PathVariable String id){
        userService.enableUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
/*
    @GetMapping("/getAllSpaces")
    public ResponseEntity<List<SpaceResponseDTO>> getAllSpaces(){

        List<SpaceResponseDTO> spaceResponseDTOList = userService.getAllSpaces();
        return ResponseEntity.ok(spaceResponseDTOList);

    }
    @PutMapping("/{id}/addSpace/{idSpace}")
    public ResponseEntity<UserResponseDTO> addSpaceToUser(@PathVariable String id, @PathVariable Long idSpace){

        UserResponseDTO userResponseDTO = userService.addSpaceToUser(id, idSpace);
        return new ResponseEntity<>(userResponseDTO, HttpStatus.OK);
    }


*/
    // add board to user
    // delete board from user
    // update board from user
}
