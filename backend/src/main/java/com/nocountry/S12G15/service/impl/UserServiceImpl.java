package com.nocountry.S12G15.service.impl;

import com.nocountry.S12G15.domain.entity.SpaceEntity;
import com.nocountry.S12G15.domain.entity.UserEntity;
import com.nocountry.S12G15.dto.request.UserRequestDTO;
import com.nocountry.S12G15.dto.response.SpaceResponseDTO;
import com.nocountry.S12G15.mapper.SpaceMapper;
import com.nocountry.S12G15.mapper.UserMapper;
import com.nocountry.S12G15.persistance.repository.UserRepository;
import com.nocountry.S12G15.dto.response.UserResponseDTO;
import com.nocountry.S12G15.service.SpaceService;
import com.nocountry.S12G15.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    public final UserRepository userRepository;

    public final SpaceService spaceService;
    public final UserMapper userMapper;

    public final SpaceMapper spaceMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, SpaceService spaceService, SpaceMapper spaceMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.spaceService = spaceService;
        this.spaceMapper = spaceMapper;
    }
    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<UserEntity> userList = userRepository.findAll();
        List<UserResponseDTO> userResponseDTOList =  userMapper.toUserResponseDTOList(userList);
        return userResponseDTOList;
    }

    @Override
    public UserResponseDTO getUserById(String id) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(id);
        if(!userEntityOptional.isPresent()){
            return null;
        }

        UserResponseDTO userResponseDTO = userMapper.toUserResponseDto(userEntityOptional.get());
        return userResponseDTO;
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        UserEntity userEntity1 = userMapper.toUserEntity(userRequestDTO);
        UserEntity userEntity = userRepository.save(userEntity1);
        UserResponseDTO userResponseDTO = userMapper.toUserResponseDto(userEntity);
        return userResponseDTO;
    }

    @Override
    public void disableUser(String id) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(id);
        if(!userEntityOptional.isPresent()){
            return;
        }
        UserEntity userEntity = userEntityOptional.get();
        userEntity.setDisabled(true);
        userRepository.save(userEntity);
    }

    @Override
    public void enableUser(String id) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(id);
        if(!userEntityOptional.isPresent()){
            return;
        }
        UserEntity userEntity = userEntityOptional.get();
        userEntity.setDisabled(false);
        userRepository.save(userEntity);
    }

    @Override
    public void deleteUser(String id) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(id);
        if(!userEntityOptional.isPresent()){
            return;
        }
        userRepository.deleteById(id);


    }

    @Override
    public List<SpaceResponseDTO> getAllSpaces() {

        List<SpaceResponseDTO> spaceEntityList = spaceService.getAllSpaces();


        return spaceEntityList;
    }



    @Override
    public UserResponseDTO addSpaceToUser(String id, Long idSpace) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(id);
        SpaceResponseDTO spaceResponseDTO = spaceService.getSpaceById(idSpace);
        if(!userEntityOptional.isPresent() || spaceResponseDTO == null){
            return null;
        }
        UserEntity userEntity = userEntityOptional.get();
        userEntity.getSpaceEntityList().add(spaceMapper.toSpaceEntity(spaceResponseDTO));
        userRepository.save(userEntity);
        return null;
    }
}
