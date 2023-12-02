package com.nocountry.S12G15.controller.dto;

import com.nocountry.S12G15.domain.entity.BoardEntity;
import com.nocountry.S12G15.dto.BoardDTO;
import com.nocountry.S12G15.service.impl.BoardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.nocountry.S12G15.util.Constant.*;

@RestController
@RequestMapping(value = API_VERSION + RESOURCE_BOARD)
public class BoardController {

    @Autowired
    private BoardServiceImpl boardService;

    @PostMapping("/register")
    public ResponseEntity<BoardDTO> createBoard(@RequestBody BoardDTO boardDTO) {
        BoardDTO savedBoardDTO = boardService.createBoard(boardDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedBoardDTO);
    }

    @GetMapping("/listOfBoards")
    public ResponseEntity<List<BoardDTO>> getBoards() {
        List<BoardDTO> boardsDTO = boardService.getEnabledBoards();

        return ResponseEntity.status(HttpStatus.OK).body(boardsDTO);
    }

    @GetMapping("/{idBoard}")
    public ResponseEntity<BoardDTO> findBoardById(@PathVariable String idBoard) {
        BoardDTO boardDTO = boardService.findBoardById(idBoard);

        return ResponseEntity.status(HttpStatus.OK).body(boardDTO);
    }

    @PutMapping("/update/{idBoard}")
    public ResponseEntity<BoardDTO> updateBoard(@PathVariable String idBoard, @RequestBody BoardDTO updatedBoardDTO) {
        BoardDTO boardDTO = boardService.updateBoard(idBoard, updatedBoardDTO);

        return ResponseEntity.status(HttpStatus.OK).body(boardDTO);
    }


    @PutMapping("/disable/{idBoard}")
    public ResponseEntity<BoardDTO> disableBoard(@PathVariable String idBoard) {
        BoardDTO boardDTO = boardService.findBoardById(idBoard);
        BoardDTO disabledBoardDTO = boardService.disableBoard(idBoard);

        return ResponseEntity.status(HttpStatus.OK).body(disabledBoardDTO);
    }

    @PutMapping("/enable/{idBoard}")
    public ResponseEntity<BoardDTO> enableBoard(@PathVariable String idBoard) {
        BoardDTO boardDTO = boardService.findBoardById(idBoard);
        BoardDTO enabledBoardDTO = boardService.enableBoard(idBoard);

        return ResponseEntity.status(HttpStatus.OK).body(enabledBoardDTO);
    }

    @PutMapping("/addTask/{idTask}/toBoard/{idBoard}")
    public ResponseEntity<BoardDTO> addTaskToBoard(@PathVariable String idBoard, @PathVariable String idTask) {
        BoardDTO boardDTO = boardService.addTaskToBoard(idBoard, idTask);

        return ResponseEntity.status(HttpStatus.OK).body(boardDTO);
    }

}