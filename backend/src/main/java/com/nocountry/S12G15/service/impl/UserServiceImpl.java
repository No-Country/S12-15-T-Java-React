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

import java.util.*;

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
    public Optional<UserResponseDTO> getUserById(String id) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(id);
        if(userEntityOptional.isPresent()){
            UserResponseDTO userResponseDTO = userMapper.toUserResponseDto(userEntityOptional.get());
            return Optional.of(userResponseDTO);
        }
        return Optional.empty();
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
    public UserResponseDTO addSpaceToUser(String id, String idSpace) {
        UserEntity userEntity = userRepository.findById(id).get();
        SpaceResponseDTO spaceResponseDTO = spaceService.findSpaceById(idSpace);
        userEntity.getSpaceEntityList().add(spaceMapper.spaceResponseDTOToSpaceEntity(spaceResponseDTO));

        return userMapper.toUserResponseDto(userRepository.save(userEntity));

    }

    @Override
    public Optional<UserResponseDTO> getUserByEmail(String email) {
        Optional<UserEntity> userEntityOptional = userRepository.findUserByEmail(email);
        if(userEntityOptional.isPresent()){
            UserResponseDTO userResponseDTO = userMapper.toUserResponseDto(userEntityOptional.get());
            return Optional.of(userResponseDTO);
        }
        return Optional.empty();
    }

    @Override
    public List<UserResponseDTO> getAllEnabledUsers() {
        List<UserEntity> userEntityList = userRepository.findByDisabledFalse();
        List<UserResponseDTO> userResponseDTOList = userMapper.toUserResponseDTOList(userEntityList);
        return userResponseDTOList;

    }
    @Override
    public Optional<UserResponseDTO> getEnabledUserById(String id) {
        Optional<UserEntity> userEntityOptional = userRepository.findByIdAndDisabledFalse(id);
        if(userEntityOptional.isPresent()){
            UserResponseDTO userResponseDTO = userMapper.toUserResponseDto(userEntityOptional.get());
            return Optional.of(userResponseDTO);
        }
        return Optional.empty();
    }


    @Override
    public Optional<UserResponseDTO> getEnabledUserByEmail(String email) {
        Optional<UserEntity> userEntityOptional = userRepository.findByEmailAndDisabledFalse(email);
        if(userEntityOptional.isPresent()){
            UserResponseDTO userResponseDTO = userMapper.toUserResponseDto(userEntityOptional.get());
            return Optional.of(userResponseDTO);
        }
        return Optional.empty();
    }

    @Override
    public List<SpaceResponseDTO> getAllSpaces(String userId) {
        List<SpaceEntity> spaceEntityList = userRepository.findById(userId).get().getSpaceEntityList();
        List<SpaceResponseDTO> spaceResponseDTOList = spaceMapper.toSpaceResponseDtoList(spaceEntityList);

        return spaceResponseDTOList;
    }

    @Override
    public List<SpaceResponseDTO> getAllEnabledSpaces(String userId) {
        List<SpaceEntity> spaceEntityList = userRepository.findById(userId).get().getSpaceEntityList();
        List<SpaceResponseDTO> spaceResponseDTOList = new ArrayList<>();
        spaceEntityList.forEach(spaceEntity -> {
            if(spaceEntity.isEnabled() == true){
                spaceResponseDTOList.add(spaceMapper.spaceToSpaceResponseDto(spaceEntity));
            }
        });
        return spaceResponseDTOList;
    }

    @Override
    public Optional<SpaceResponseDTO> getEnabledSpaceById(String idSpace) {
        Optional<SpaceResponseDTO> spaceResponseDTO = spaceService.getEnabledSpaceById(idSpace);
        if(spaceResponseDTO.isPresent()){
            return spaceResponseDTO;
        }
        return Optional.empty();
    }


}
