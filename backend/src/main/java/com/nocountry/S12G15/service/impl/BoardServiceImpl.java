package com.nocountry.S12G15.service.impl;

import com.nocountry.S12G15.domain.entity.BoardEntity;
import com.nocountry.S12G15.domain.entity.TaskEntity;
import com.nocountry.S12G15.dto.BoardDTO;
import com.nocountry.S12G15.exception.MyException;
import com.nocountry.S12G15.mapper.BoardMapper;
import com.nocountry.S12G15.mapper.TaskMapper;
import com.nocountry.S12G15.persistance.repository.BoardRepository;
import com.nocountry.S12G15.persistance.repository.TaskRepository;
import com.nocountry.S12G15.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nocountry.S12G15.exception.ExceptionMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private BoardMapper boardMapper;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskMapper taskMapper;


    @Override
    public BoardDTO createBoard(BoardDTO boardDTO) throws MyException{

        validate(boardDTO);

        BoardEntity board = boardMapper.boardDTOToBoard(boardDTO);
        board.setEnabled(true);
        BoardEntity savedBoard = boardRepository.save(board);

        return boardMapper.boardToBoardDTO(savedBoard);
    }

    @Override
    public List<BoardDTO> getAllBoards() {

        List<BoardEntity> boards = boardRepository.findAll();
        List<BoardDTO> boardsDTO = new ArrayList<>();

        for (BoardEntity board : boards) {
            BoardDTO boardDTO = boardMapper.boardToBoardDTO(board);
            boardsDTO.add(boardDTO);
        }
        return boardsDTO;
    }

    @Override
    public List<BoardDTO> getEnabledBoards() {

        List<BoardDTO> boardsDTO = getAllBoards();

        return boardsDTO.stream().filter(BoardDTO::isEnabled).collect(Collectors.toList());
    }

    @Override
    public BoardDTO findBoardById(String idBoard) {

        BoardEntity board = boardRepository.findById(idBoard).orElse(null);

        if (board != null) {
            return boardMapper.boardToBoardDTO(board);
        } else {
            System.out.println("It wasn't possible to find a board with the ID: " + idBoard);
            return null;
        }
    }

    @Override
    public BoardDTO updateBoard(String idBoard, BoardDTO updatedBoardDTO) throws MyException{

        validate(updatedBoardDTO);

        BoardEntity board = boardRepository.findById(idBoard).orElse(null);

        if (board != null) {
            board.setDescription(updatedBoardDTO.getDescription());
            board.setBoardName(updatedBoardDTO.getBoardName());
        }

        BoardEntity savedBoard = boardRepository.save(board);
        return boardMapper.boardToBoardDTO(savedBoard);
    }

    @Override
    public BoardDTO disableBoard(String idBoard) {

        BoardEntity board = boardRepository.findById(idBoard).orElse(null);

        if (board != null) {
            board.setEnabled(false);
            BoardEntity savedBoard = boardRepository.save(board);
            return boardMapper.boardToBoardDTO(savedBoard);
        } else {
            System.out.println("It wasn't possible to find a board with the ID: " + idBoard);
            return null;
        }
    }

    @Override
    public BoardDTO enableBoard(String idBoard) {

        BoardEntity board = boardRepository.findById(idBoard).orElse(null);

        if (board != null) {
            board.setEnabled(true);
            BoardEntity savedBoard = boardRepository.save(board);
            return boardMapper.boardToBoardDTO(savedBoard);
        } else {
            System.out.println("It wasn't possible to find a board with the ID: " + idBoard);
            return null;
        }
    }

    @Override
    public BoardDTO addTaskToBoard(String idBoard, String idTask) throws MyException{
        BoardEntity board = boardRepository.findById(idBoard).orElse(null);
        TaskEntity task = taskRepository.findById(idTask).orElse(null);

        if (board == null || task == null) {
            throw new MyException("Board or task can't be null or empty");
        }

        board.getTasks().add(task);
        board = boardRepository.save(board);

        return boardMapper.boardToBoardDTO(board);
    }

    public void validate(BoardDTO boardDTO) throws MyException {

        if (boardDTO.getBoardName() == null || ExceptionMethods.onlySpaces(boardDTO.getBoardName())) {
            throw new MyException("Board's name can't be null or empty.");
        }
    }
}