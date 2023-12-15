package com.nocountry.S12G15.controller;

import com.nocountry.S12G15.dto.request.UserRequestDTO;
//import com.nocountry.S12G15.dto.response.SpaceResponseDTO;
import com.nocountry.S12G15.dto.response.SpaceResponseDTO;
import com.nocountry.S12G15.dto.response.UserResponseDTO;
//import com.nocountry.S12G15.service.SpaceService;
import com.nocountry.S12G15.service.UserService;
import com.nocountry.S12G15.service.impl.UserServiceImpl;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.nocountry.S12G15.util.Constant.*;

@RestController
@RequestMapping(value = API_VERSION + RESOURCE_USER)
public class UserController {

    private final UserService userService;



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
    /*
    @PostMapping("/create")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userRequestDTO){
        UserResponseDTO userResponseDTO1 = userService.createUser(userRequestDTO);
        return new ResponseEntity<>(userResponseDTO1, HttpStatus.CREATED);
    }

     */
    @DeleteMapping("/deleteuser/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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


    @PutMapping("/enabled/{userId}/addSpace/{idSpace}")
    public ResponseEntity<?> addSpaceToUserFromId(@PathVariable String userId, @PathVariable String idSpace){
        Optional<UserResponseDTO> userResponseDTO = userService.getEnabledUserById(userId);
        if(userResponseDTO.isEmpty()){
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        Optional<SpaceResponseDTO> spaceResponseDTO = userService.getEnabledSpaceById(idSpace);
        if(spaceResponseDTO.isEmpty()){
            return new ResponseEntity<>("Space not found", HttpStatus.NOT_FOUND);
        }
        UserResponseDTO userResponseDTOSaved = userService.addSpaceToUser(userId, idSpace);
        //userResponseDTO = userService.addSpaceToUser(userId, idSpace);
        return new ResponseEntity<>(userResponseDTOSaved, HttpStatus.OK);
    }
    @PutMapping("/enabled/{userEmail}/addSpace/{idSpace}")
    public ResponseEntity<?> addSpaceToUserFromEmail(@PathVariable String userEmail, @PathVariable String idSpace){
        Optional<UserResponseDTO> userResponseDTO = userService.getEnabledUserByEmail(userEmail);
        if(userResponseDTO.isEmpty()){
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        Optional<SpaceResponseDTO> spaceResponseDTO = userService.getEnabledSpaceById(idSpace);
        if(spaceResponseDTO.isEmpty()){
            return new ResponseEntity<>("Space not found", HttpStatus.NOT_FOUND);
        }
        UserResponseDTO userResponseDTOSaved = userService.addSpaceToUser(userResponseDTO.get().id(), idSpace);

        return new ResponseEntity<>(userResponseDTOSaved, HttpStatus.OK);
    }


}
