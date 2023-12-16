package com.nocountry.S12G15.service.impl;

import com.nocountry.S12G15.domain.entity.UserEntity;
import com.nocountry.S12G15.dto.request.AuthLoginRequestDTO;
import com.nocountry.S12G15.dto.request.AuthRegisterRequestDTO;
import com.nocountry.S12G15.dto.response.AuthResponseDTO;
import com.nocountry.S12G15.enums.RolUser;
import com.nocountry.S12G15.exception.InvalidPasswordException;
import com.nocountry.S12G15.persistance.repository.UserRepository;
import com.nocountry.S12G15.service.AuthService;
import com.nocountry.S12G15.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import static com.nocountry.S12G15.enums.RolUser.USER;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public AuthResponseDTO register(AuthRegisterRequestDTO request) {

        validatePassword(request);

        var user = UserEntity.builder()
                .email(request.getEmail())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .rolUser(RolUser.USER)
                .build();

        userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);

        String id = user.getId();
        String email = user.getEmail();
        String lastName = user.getLastName();
        String name = user.getName();
        RolUser rol = user.getRolUser();
        String userName = user.getUsername();
        return AuthResponseDTO.builder()
                .id(id)
                .lastName(lastName)
                .userName(userName)
                .name(name)
                .rol(rol)
                .token(jwtToken)
                .email(email)
                .build();
    }

    @Override
    public AuthResponseDTO login(AuthLoginRequestDTO request) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findUserByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);

        String id = user.getId();
        String name = user.getName();
        String lastName = user.getLastName();
        String email = user.getEmail();
        RolUser rol = user.getRolUser();
        String userName = user.getUsername();
        return AuthResponseDTO.builder()
                .id(id)
                .token(jwtToken)
                .userName(userName)
                .name(name)
                .lastName(lastName)
                .email(email)
                .rol(rol)
                .build();

    }

    private void validatePassword(AuthRegisterRequestDTO request) {

        if(!StringUtils.hasText(request.getPassword()) || !StringUtils.hasText(request.getRepeatedPassword())){
            throw new InvalidPasswordException("Passwords don't match");
        }

        if(!request.getPassword().equals(request.getRepeatedPassword())){
            throw new InvalidPasswordException("Passwords don't match");
        }
    }
}
