package com.nocountry.S12G15.service;

import com.nocountry.S12G15.dto.request.UserRequestDTO;
import com.nocountry.S12G15.dto.response.SpaceResponseDTO;
import com.nocountry.S12G15.dto.response.UserResponseDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserResponseDTO> getAllUsers();

    Optional<UserResponseDTO> getUserById(String id);

    UserResponseDTO createUser(UserRequestDTO userRequestDTO);

    void disableUser(String id);

    void enableUser(String id);

    void deleteUser(String id);

    UserResponseDTO addSpaceToUser(String id, String idSpace);

   
    Optional<UserResponseDTO> getUserByEmail(String email);

    List<UserResponseDTO> getAllEnabledUsers();

    Optional<UserResponseDTO> getEnabledUserById(String id);

    Optional<UserResponseDTO> getEnabledUserByEmail(String email);

    List<SpaceResponseDTO> getAllSpaces(String userId);

    List<SpaceResponseDTO> getAllEnabledSpaces(String userId);

    Optional<SpaceResponseDTO> getEnabledSpaceById(String idSpace);
}
