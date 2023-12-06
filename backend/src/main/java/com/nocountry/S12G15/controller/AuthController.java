package com.nocountry.S12G15.controller;

import com.nocountry.S12G15.dto.request.AuthLoginRequestDTO;
import com.nocountry.S12G15.dto.request.AuthRegisterRequestDTO;
import com.nocountry.S12G15.dto.response.AuthResponseDTO;
import com.nocountry.S12G15.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.nocountry.S12G15.util.Constant.API_VERSION;
import static com.nocountry.S12G15.util.Constant.RESOURCE_AUTH;

@RestController
@RequestMapping(value = API_VERSION + RESOURCE_AUTH)
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> register(@RequestBody AuthRegisterRequestDTO request){
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthLoginRequestDTO request){
        return ResponseEntity.ok(authService.login(request));
    }

}
