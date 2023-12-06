package com.nocountry.S12G15.service;

import com.nocountry.S12G15.domain.entity.UserEntity;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;
import java.util.function.Function;

public interface JwtService {

    String generateToken(UserEntity userEntity);

    String generateToken(Map<String, Object> extraClaims, UserEntity userEntity);

    String getUserName(String token);

    <T> T getClaim(String token, Function<Claims, T> claimsResolver);

    boolean validateToken(String token, UserDetails userDetails);
}
