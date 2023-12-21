package com.nocountry.S12G15.service;


import com.nocountry.S12G15.dto.BoardDTO;
import com.nocountry.S12G15.dto.request.SpaceRequestDTO;
import com.nocountry.S12G15.dto.response.ChannelResponseDTO;
import com.nocountry.S12G15.dto.response.SpaceResponseDTO;
import com.nocountry.S12G15.exception.MyException;

import java.util.List;
import java.util.Optional;
//import org.springframework.stereotype.Service;


public interface SpaceService {


    SpaceResponseDTO createSpace(SpaceRequestDTO newSpace) throws MyException;
    List<SpaceResponseDTO> getAllSpaces();
    List<SpaceResponseDTO> getEnabledSpaces();
    SpaceResponseDTO findSpaceById(String idSpace);
    SpaceResponseDTO updateSpace(String idSpace, SpaceRequestDTO updatedSpaceDTO) throws MyException;
    SpaceResponseDTO disableSpace(String idSpace);
    SpaceResponseDTO enableSpace(String idSpace);
    SpaceResponseDTO addChannelToSpace(String idSpace, String idChannel) throws MyException;
    SpaceResponseDTO addBoardToSpace(String idSpace, String idBoard) throws MyException;
    Optional<SpaceResponseDTO> getEnabledSpaceById(String idSpace);
    List<BoardDTO> getAllBoards(String idSpace);
    List<BoardDTO> getAllEnabledBoards(String idSpace);
    List<ChannelResponseDTO> getAllChannels(String idSpace);
    List<ChannelResponseDTO> getAllEnabledChannels(String idSpace);
}
