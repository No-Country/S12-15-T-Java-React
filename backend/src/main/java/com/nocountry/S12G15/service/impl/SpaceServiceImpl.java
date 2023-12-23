package com.nocountry.S12G15.service.impl;

import com.nocountry.S12G15.domain.entity.BoardEntity;
import com.nocountry.S12G15.domain.entity.ChannelEntity;
import com.nocountry.S12G15.domain.entity.SpaceEntity;
import com.nocountry.S12G15.dto.BoardDTO;
import com.nocountry.S12G15.dto.request.ChannelRequestDTO;
import com.nocountry.S12G15.dto.request.SpaceRequestDTO;
import com.nocountry.S12G15.dto.response.ChannelResponseDTO;
import com.nocountry.S12G15.dto.response.SpaceResponseDTO;
import com.nocountry.S12G15.exception.ExceptionMethods;
import com.nocountry.S12G15.exception.MyException;
import com.nocountry.S12G15.mapper.BoardMapper;
import com.nocountry.S12G15.mapper.ChannelMapper;
import com.nocountry.S12G15.mapper.SpaceMapper;
import com.nocountry.S12G15.persistance.repository.BoardRepository;
import com.nocountry.S12G15.persistance.repository.ChannelRepository;
import com.nocountry.S12G15.persistance.repository.SpaceRepository;
import com.nocountry.S12G15.service.BoardService;
import com.nocountry.S12G15.service.ChannelService;
import com.nocountry.S12G15.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SpaceServiceImpl implements SpaceService {

    private final SpaceMapper spaceMapper;
    private final SpaceRepository spaceRepository;
    private final ChannelRepository channelRepository;
    private final BoardRepository boardRepository;
    private final BoardService boardService;
    private final ChannelService channelService;
    private final ChannelMapper channelMapper;
    private final BoardMapper boardMapper;

    @Autowired
    public SpaceServiceImpl(SpaceMapper spaceMapper, SpaceRepository spaceRepository, ChannelRepository channelRepository, BoardRepository boardRepository, BoardService boardService, ChannelService channelService, ChannelMapper channelMapper, BoardMapper boardMapper) {
        this.spaceMapper = spaceMapper;
        this.spaceRepository = spaceRepository;
        this.channelRepository = channelRepository;
        this.boardRepository = boardRepository;
        this.boardService = boardService;
        this.channelService = channelService;
        this.channelMapper = channelMapper;
        this.boardMapper = boardMapper;
    }

    @Override
    public SpaceResponseDTO createSpace(SpaceRequestDTO spaceRequestDTO) throws MyException {

        validate(spaceRequestDTO);

        SpaceEntity space = spaceMapper.spaceRequestDTOToSpaceEntity(spaceRequestDTO);
        space.setEnabled(true);
        space.setCreatedAt(LocalDate.now());

        ChannelRequestDTO channelRequestDTO = new ChannelRequestDTO();
        channelRequestDTO.setNameChannel("General");


        ChannelResponseDTO channelResponseDTO = channelService.createChannel(channelRequestDTO);

        List<ChannelEntity> channelEntityList = new ArrayList<>();
        List<BoardEntity> boardEntityList = new ArrayList<>();
        space.setBoards(boardEntityList);
        space.setChannels(channelEntityList);

        space.getChannels().add(channelMapper.toGetChannelEntityFromChannelResponseDTO(channelResponseDTO));
        BoardDTO boardDTO = BoardDTO.builder()
                .boardName("General")
                .description("Tu Primer Tablero")
                .build();
        BoardDTO boardDTOSaved = boardService.createBoard(boardDTO);

        space.getBoards().add(boardMapper.boardDTOToBoard(boardDTOSaved));

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

    @Override
    public List<BoardDTO> getAllBoards(String idSpace) {
        List<BoardEntity> boardEntityList = spaceRepository.findById(idSpace).get().getBoards();
        return boardMapper.toBoardDTOList(boardEntityList);
    }

    @Override
    public List<BoardDTO> getAllEnabledBoards(String idSpace) {
        List<BoardEntity> boardEntityList = spaceRepository.findById(idSpace).get().getBoards();
        List<BoardDTO> boardDTOList = new ArrayList<>();
        boardEntityList.forEach(boardEntity -> {
            if(boardEntity.isEnabled()){
                boardDTOList.add(boardMapper.boardToBoardDTO(boardEntity));
            }
        });
        return boardDTOList;
    }

    @Override
    public List<ChannelResponseDTO> getAllChannels(String idSpace) {
        List<ChannelEntity> channelEntityList = spaceRepository.findById(idSpace).get().getChannels();
        List<ChannelResponseDTO> channelResponseDTOList = channelMapper.toChannelResponseDtoList(channelEntityList);

        return channelResponseDTOList;
    }

    @Override
    public List<ChannelResponseDTO> getAllEnabledChannels(String idSpace) {
        List<ChannelEntity> channelEntityList = spaceRepository.findById(idSpace).get().getChannels();
        List<ChannelResponseDTO> channelResponseDTOList = new ArrayList<>();
        channelEntityList.forEach(channelEntity -> {
            if(channelEntity.getStatus().toString().equalsIgnoreCase("DISABLED")){
                channelResponseDTOList.add(channelMapper.toGetChannelResponseDto(channelEntity));
            }
        });
        return channelResponseDTOList;
    }

    private void validate(SpaceRequestDTO spaceRequestDTO) throws MyException {

        if (spaceRequestDTO.getName() == null || ExceptionMethods.onlySpaces(spaceRequestDTO.getName())) {
            throw new MyException("Space's name can't be null or empty.");
        }
    }

}
