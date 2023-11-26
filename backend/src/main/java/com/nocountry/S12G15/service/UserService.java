package com.nocountry.S12G15.service;

import com.nocountry.S12G15.dto.response.UserResponseDTO;

import java.util.List;


public interface UserService {
    List<UserResponseDTO> getAllUsers();
}
