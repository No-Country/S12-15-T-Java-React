package com.nocountry.S12G15.controller.dto;

import com.nocountry.S12G15.domain.entity.ImageEntity;
import com.nocountry.S12G15.dto.BoardDTO;
import com.nocountry.S12G15.exception.MyException;
import com.nocountry.S12G15.service.ImageService;
import com.nocountry.S12G15.service.impl.BoardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static com.nocountry.S12G15.util.Constant.*;

@RestController
@RequestMapping(value = API_VERSION + RESOURCE_BOARD)
public class BoardController {

    @Autowired
    private BoardServiceImpl boardService;

    @Autowired
    private ImageService imageService;

    @PostMapping("/register")
    public ResponseEntity<BoardDTO> createBoard(@RequestBody BoardDTO boardDTO) throws MyException {

        BoardDTO savedBoardDTO = boardService.createBoard(boardDTO);

        if (boardDTO.getBoardName() == null ) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBoardDTO);
    }

    @GetMapping("/listOfBoards")
    public ResponseEntity<List<BoardDTO>> getBoards() {
        List<BoardDTO> boardsDTO = boardService.getEnabledBoards();

        if (boardsDTO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(boardsDTO);
    }

    @GetMapping("/{idBoard}")
    public ResponseEntity<BoardDTO> findBoardById(@PathVariable String idBoard) {
        BoardDTO boardDTO = boardService.findBoardById(idBoard);

        if (boardDTO != null) {
            return ResponseEntity.status(HttpStatus.OK).body(boardDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/update/{idBoard}")
    public ResponseEntity<BoardDTO> updateBoard(@PathVariable String idBoard, @RequestBody BoardDTO updatedBoardDTO) throws MyException {
        BoardDTO boardDTO = boardService.updateBoard(idBoard, updatedBoardDTO);

        if (updatedBoardDTO.getBoardName() == null || boardDTO.getIdBoard() == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }

        return ResponseEntity.status(HttpStatus.OK).body(boardDTO);
    }


    @PutMapping("/disable/{idBoard}")
    public ResponseEntity<BoardDTO> disableBoard(@PathVariable String idBoard) {
        BoardDTO boardDTO = boardService.findBoardById(idBoard);
        BoardDTO disabledBoardDTO = boardService.disableBoard(idBoard);

        if (boardDTO != null) {
            return ResponseEntity.status(HttpStatus.OK).body(disabledBoardDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/enable/{idBoard}")
    public ResponseEntity<BoardDTO> enableBoard(@PathVariable String idBoard) {
        BoardDTO boardDTO = boardService.findBoardById(idBoard);
        BoardDTO enabledBoardDTO = boardService.enableBoard(idBoard);

        if (boardDTO != null) {
            return ResponseEntity.status(HttpStatus.OK).body(enabledBoardDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/addTask/{idTask}/toBoard/{idBoard}")
    public ResponseEntity<BoardDTO> addTaskToBoard(@PathVariable String idBoard, @PathVariable String idTask) throws MyException{
        BoardDTO boardDTO = boardService.addTaskToBoard(idBoard, idTask);

        if (boardDTO.getTasks().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(boardDTO);
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<?> upLoadPhoto (@RequestParam MultipartFile file, @RequestParam String idBoard){

        ImageEntity imageEntity = imageService.saveImage(file, idBoard);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/v1/api/board/getPhoto")
                .queryParam("idBoard", idBoard)
                .build()
                .toUri();

        return ResponseEntity.status(HttpStatus.CREATED).body(uri);
    }

    @GetMapping("/getPhoto")
    public ResponseEntity<byte[]> getPhoto(@RequestParam String idBoard){

        byte[] image = imageService.getPhoto(idBoard);

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.IMAGE_JPEG);

        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(image);
    }
}