package com.nocountry.S12G15.service;

import com.nocountry.S12G15.domain.entity.BoardEntity;
import com.nocountry.S12G15.dto.BoardDTO;

import java.util.List;

public interface BoardService {

    BoardDTO createBoard(BoardDTO boardDTO);
    List<BoardDTO> getAllBoards();
    List<BoardDTO> getEnabledBoards();
    BoardDTO findBoardById(String idBoard);
    BoardDTO  updateBoard(String idBoard, BoardDTO updatedBoardDTO);
    BoardDTO disableBoard(String idBoard);
    BoardDTO enableBoard(String idBoard);
    BoardDTO addTaskToBoard(String idBoard, String idTask);


}
