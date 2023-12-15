package com.nocountry.S12G15.service.impl;

import com.nocountry.S12G15.domain.entity.BoardEntity;
import com.nocountry.S12G15.domain.entity.ChannelEntity;
import com.nocountry.S12G15.domain.entity.SpaceEntity;
import com.nocountry.S12G15.dto.request.SpaceRequestDTO;
import com.nocountry.S12G15.dto.response.SpaceResponseDTO;
import com.nocountry.S12G15.exception.ExceptionMethods;
import com.nocountry.S12G15.exception.MyException;
import com.nocountry.S12G15.mapper.SpaceMapper;
import com.nocountry.S12G15.persistance.repository.BoardRepository;
import com.nocountry.S12G15.persistance.repository.ChannelRepository;
import com.nocountry.S12G15.persistance.repository.SpaceRepository;
import com.nocountry.S12G15.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SpaceServiceImpl implements SpaceService {


    @Autowired
    private SpaceMapper spaceMapper;
    @Autowired
    private SpaceRepository spaceRepository;
    @Autowired
    private ChannelRepository channelRepository;
    @Autowired
    private BoardRepository boardRepository;

    @Override
    public SpaceResponseDTO createSpace(SpaceRequestDTO spaceRequestDTO) throws MyException {
        validate(spaceRequestDTO);

        SpaceEntity space = spaceMapper.spaceRequestDTOToSpaceEntity(spaceRequestDTO);
        space.setEnabled(true);
        space.setCreatedAt(LocalDate.now());
        SpaceEntity savedSpace = spaceRepository.save(space);

        return spaceMapper.spaceToSpaceResponseDto(savedSpace);
    }

    @Override
    public List<SpaceResponseDTO> getAllSpaces() {
        return spaceMapper.toSpaceResponseDtoList(spaceRepository.findAll());
    }

    @Override
    public List<SpaceResponseDTO> getEnabledSpaces() {
        List<SpaceResponseDTO> spacesDTO = getAllSpaces();

        return spacesDTO.stream().filter(SpaceResponseDTO::isEnabled).collect(Collectors.toList());
    }

    @Override
    public SpaceResponseDTO findSpaceById(String idSpace) {
        SpaceEntity space = spaceRepository.findById(idSpace).orElse(null);

        if (space != null) {
            return spaceMapper.spaceToSpaceResponseDto(space);
        } else {
            System.out.println("It wasn't possible to find a space with the ID: " + idSpace);
            return null;
        }
    }

    @Override
    public SpaceResponseDTO updateSpace(String idSpace, SpaceRequestDTO updatedSpaceDTO) throws MyException {
        validate(updatedSpaceDTO);

        SpaceEntity space = spaceRepository.findById(idSpace).orElse(null);

        if (space != null) {
            space.setName(updatedSpaceDTO.getName());
            space.setDescription(updatedSpaceDTO.getDescription());
            space.setImageEntity(updatedSpaceDTO.getImageEntity());
        }

        SpaceEntity savedSpace = spaceRepository.save(space);
        return spaceMapper.spaceToSpaceResponseDto(savedSpace);
    }

    @Override
    public SpaceResponseDTO disableSpace(String idSpace) {

        SpaceEntity space = spaceRepository.findById(idSpace).orElse(null);

        if (space != null) {
            space.setEnabled(false);
            SpaceEntity savedSpace = spaceRepository.save(space);
            return spaceMapper.spaceToSpaceResponseDto(savedSpace);
        } else {
            System.out.println("It wasn't possible to find a space with the ID: " + idSpace);
            return null;
        }
    }

    @Override
    public SpaceResponseDTO enableSpace(String idSpace) {

        SpaceEntity space = spaceRepository.findById(idSpace).orElse(null);

        if (space != null) {
            space.setEnabled(true);
            SpaceEntity savedSpace = spaceRepository.save(space);
            return spaceMapper.spaceToSpaceResponseDto(savedSpace);
        } else {
            System.out.println("It wasn't possible to find a space with the ID: " + idSpace);
            return null;
        }
    }

    @Override
    public SpaceResponseDTO addChannelToSpace(String idSpace, String idChannel) throws MyException {
        SpaceEntity space = spaceRepository.findById(idSpace).orElse(null);
        ChannelEntity channel = channelRepository.findById(idChannel).orElse(null);

        if (space == null || channel == null) {
            throw new MyException("Space or Channel can´t be null or empty");
        }

        space.getChannels().add(channel);
        space = spaceRepository.save(space);

        return spaceMapper.spaceToSpaceResponseDto(space);
    }

    @Override
    public SpaceResponseDTO addBoardToSpace(String idSpace, String idBoard) throws MyException{
        SpaceEntity space = spaceRepository.findById(idSpace).orElse(null);
        BoardEntity board = boardRepository.findById(idBoard).orElse(null);

        if (space == null || board == null) {
            throw new MyException("Space or Board can´t be null or empty");
        }

        space.getBoards().add(board);
        space = spaceRepository.save(space);

        return spaceMapper.spaceToSpaceResponseDto(space);
    }

    @Override
    public Optional<SpaceResponseDTO> getEnabledSpaceById(String idSpace) {
        Optional<SpaceEntity> spaceEntityOptional = spaceRepository.findById(idSpace);
        if(spaceEntityOptional.isPresent()){
            SpaceResponseDTO spaceResponseDTO = spaceMapper.spaceToSpaceResponseDto(spaceEntityOptional.get());
            return Optional.of(spaceResponseDTO);
        }
        return Optional.empty();
    }

    private void validate(SpaceRequestDTO spaceRequestDTO) throws MyException {

        if (spaceRequestDTO.getName() == null || ExceptionMethods.onlySpaces(spaceRequestDTO.getName())) {
            throw new MyException("Space's name can't be null or empty.");
        }
    }

}
