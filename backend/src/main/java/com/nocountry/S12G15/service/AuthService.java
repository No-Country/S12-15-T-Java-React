package com.nocountry.S12G15.service;

import com.nocountry.S12G15.dto.request.AuthLoginRequestDTO;
import com.nocountry.S12G15.dto.request.AuthRegisterRequestDTO;
import com.nocountry.S12G15.dto.response.AuthResponseDTO;

public interface AuthService {

    AuthResponseDTO register(AuthRegisterRequestDTO request);

    AuthResponseDTO login(AuthLoginRequestDTO request);

}
