package com.nocountry.S12G15.service;

import com.nocountry.S12G15.dto.request.AuthenticationRequest;
import com.nocountry.S12G15.dto.response.AuthResponse;

public interface AuthService {

    AuthResponse register(AuthenticationRequest request);

    AuthResponse login(AuthenticationRequest request);

}
