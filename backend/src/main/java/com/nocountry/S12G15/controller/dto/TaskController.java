package com.nocountry.S12G15.controller.dto;

import com.nocountry.S12G15.domain.entity.TaskEntity;
import com.nocountry.S12G15.dto.TaskDTO;
import com.nocountry.S12G15.dto.request.PageableDto;
import com.nocountry.S12G15.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.nocountry.S12G15.util.Constant.API_VERSION;
import static com.nocountry.S12G15.util.Constant.RESOURCE_TASK;

@RestController
@RequestMapping(value = API_VERSION + RESOURCE_TASK)
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<Page<?>> getAllTasks(PageableDto pageableDto){
        Page<TaskDTO> tasksPage = taskService.findAll(pageableDto);

        if (tasksPage.hasContent()){
            return ResponseEntity.ok(tasksPage);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/{idTask}")
    public ResponseEntity<?> getTask(@PathVariable String idTask){

        Optional<TaskDTO> task = taskService.findTaskById(idTask);

        if(task.isPresent()){

            return ResponseEntity.ok(task.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/{idTask}/disabled")
    public ResponseEntity<?> disabledTaskById(@PathVariable String idTask){

        Optional<TaskDTO> task = taskService.findTaskById(idTask);

        if(task.isPresent()) {

            TaskEntity actualTask = taskService.disabledOneById(idTask);
            return ResponseEntity.ok(actualTask);

        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

}
