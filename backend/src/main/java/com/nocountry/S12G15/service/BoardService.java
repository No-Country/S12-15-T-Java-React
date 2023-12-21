package com.nocountry.S12G15.service;

import com.nocountry.S12G15.domain.entity.BoardEntity;
import com.nocountry.S12G15.dto.BoardDTO;
import com.nocountry.S12G15.dto.response.ChannelResponseDTO;
import com.nocountry.S12G15.dto.response.TaskResponseDTO;
import com.nocountry.S12G15.exception.MyException;

import java.util.List;

public interface BoardService {

    BoardDTO createBoard(BoardDTO boardDTO) throws MyException;
    List<BoardDTO> getAllBoards();
    List<BoardDTO> getEnabledBoards();
    BoardDTO findBoardById(String idBoard);
    BoardDTO  updateBoard(String idBoard, BoardDTO updatedBoardDTO) throws MyException;
    BoardDTO disableBoard(String idBoard);
    BoardDTO enableBoard(String idBoard);
    BoardDTO addTaskToBoard(String idBoard, String idTask) throws MyException;

    List<TaskResponseDTO> getAllTasks(String idBoard);
    List<TaskResponseDTO> getAllEnabledTasks(String idBoard);
}
