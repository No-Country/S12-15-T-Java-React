package com.nocountry.S12G15.mapper;

import com.nocountry.S12G15.domain.entity.BoardEntity;
import com.nocountry.S12G15.dto.BoardDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
uses = {BoardEntity.class, BoardDTO.class})
public interface BoardMapper {

    BoardDTO boardToBoardDTO(BoardEntity board);
    BoardEntity boardDTOToBoard(BoardDTO boardDTO);
    List<BoardDTO> toBoardDTOList(List<BoardEntity> boards);
}
