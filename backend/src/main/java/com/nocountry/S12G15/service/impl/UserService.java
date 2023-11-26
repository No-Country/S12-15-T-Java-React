package com.nocountry.S12G15.service.impl;

import com.nocountry.S12G15.domain.entity.UserEntity;
import com.nocountry.S12G15.mapper.UserMapper;
import com.nocountry.S12G15.persistance.repository.UserRepository;
import com.nocountry.S12G15.dto.response.UserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements com.nocountry.S12G15.service.UserService {
    public final UserRepository userRepository;
    public final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<UserEntity> userList = userRepository.findAll();
        List<UserResponseDTO> userResponseDTOList =  userMapper.toTransactionRequestDtoList(userList);
        return userResponseDTOList;
    }
}
