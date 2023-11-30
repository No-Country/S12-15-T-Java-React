package com.nocountry.S12G15.service;

import com.nocountry.S12G15.dto.request.UserRequestDTO;
import com.nocountry.S12G15.dto.response.SpaceResponseDTO;
import com.nocountry.S12G15.dto.response.UserResponseDTO;

import java.util.List;


public interface UserService {
    List<UserResponseDTO> getAllUsers();

    UserResponseDTO getUserById(String id);

    UserResponseDTO createUser(UserRequestDTO userRequestDTO);

    void disableUser(String id);

    void enableUser(String id);

    void deleteUser(String id);

    List<SpaceResponseDTO> getAllSpaces();

    UserResponseDTO addSpaceToUser(String id, Long idSpace);
}
