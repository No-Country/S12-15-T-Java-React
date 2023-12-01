package com.nocountry.S12G15.service;

import com.nocountry.S12G15.dto.request.AuthenticationRequest;
import com.nocountry.S12G15.dto.response.AuthResponse;

public interface AuthService {

    public AuthResponse register(AuthenticationRequest request);

    public AuthResponse login(AuthenticationRequest request);

}
