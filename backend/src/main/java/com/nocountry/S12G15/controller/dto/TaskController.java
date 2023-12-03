package com.nocountry.S12G15.controller.dto;

import com.nocountry.S12G15.domain.entity.TaskEntity;
import com.nocountry.S12G15.dto.request.TaskRequestDTO;
import com.nocountry.S12G15.dto.response.TaskResponseDTO;
import com.nocountry.S12G15.service.BoardService;
import com.nocountry.S12G15.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//import java.util.Map;
import java.util.Optional;

import static com.nocountry.S12G15.util.Constant.API_VERSION;
import static com.nocountry.S12G15.util.Constant.RESOURCE_TASK;

@RestController
@RequestMapping(value = API_VERSION + RESOURCE_TASK)
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private BoardService boardService;

    @PostMapping("/new/{idBoard}")
    public ResponseEntity<?> createTask(@RequestBody TaskRequestDTO taskRequestDTO, @PathVariable String idBoard){

        try{
            TaskResponseDTO taskResponseDTO = taskService.createTask(taskRequestDTO);
            String idTask = taskResponseDTO.getIdTask();
            boardService.addTaskToBoard(idBoard,idTask);
            return ResponseEntity.status(HttpStatus.OK).body(taskResponseDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\""+e.getMessage()+"}"));
        }

    }

    @GetMapping("/all")
    public ResponseEntity<List<TaskResponseDTO>> getAllTasks(){
        List<TaskResponseDTO> taskList = taskService.findAllTasks().orElseThrow(null);

        if(!taskList.isEmpty()){
            return new ResponseEntity<>(taskList, HttpStatus.OK);
        }

        return ResponseEntity.notFound().build();
    }
//    public ResponseEntity<?> getAllTasks(PageableDto pageableDto){
//
//        try {
//            Page<TaskResponseDTO> content = taskService.findAll2();
//            Map<String, Object> response = Map.of("message", "Listado de Tareas", "data", content.get());
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        }catch (Exception e){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\" "+e.getMessage()+"}"));
//        }
//    }

    @GetMapping("/{idTask}")
    public ResponseEntity<?> getTask(@PathVariable String idTask){
        try{
        Optional<TaskResponseDTO> task = taskService.findTaskById(idTask);
            return new ResponseEntity<>(task, HttpStatus.OK);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\" "+e.getMessage()+"}"));
        }
    }

    @PutMapping("/{idTask}/disabled")
    public ResponseEntity<?> disabledTaskById(@PathVariable String idTask){
        try{
            TaskEntity actualTask = taskService.disabledOneById(idTask);
            return ResponseEntity.ok(actualTask);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\" "+e.getMessage()+"}"));

        }

    }

    @PutMapping("/{idTask}")
    public ResponseEntity<?> updateTask(@RequestBody TaskRequestDTO taskUpdate, @PathVariable String idTask){
        try{
            TaskResponseDTO actualTask = taskService.updateTask(taskUpdate,idTask);
            return ResponseEntity.status(HttpStatus.OK).body(actualTask);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\" "+e.getMessage()+"}"));

        }
    }

}
