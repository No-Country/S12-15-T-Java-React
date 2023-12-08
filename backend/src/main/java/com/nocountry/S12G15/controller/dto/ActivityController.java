package com.nocountry.S12G15.controller.dto;

import com.nocountry.S12G15.dto.ActivityDTO;
import com.nocountry.S12G15.dto.ActivityDTO;
import com.nocountry.S12G15.exception.MyException;
import com.nocountry.S12G15.service.ActivityService;
import com.nocountry.S12G15.service.TaskService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.nocountry.S12G15.util.Constant.API_VERSION;
import static com.nocountry.S12G15.util.Constant.RESOURCE_ACTIVITY;

@RestController
@RequestMapping(value = API_VERSION + RESOURCE_ACTIVITY)
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private TaskService taskService;

    @PostMapping("/new/{idActivity}")
    public ResponseEntity<ActivityDTO> createActivity(@RequestBody ActivityDTO activityDTO, String idTask) throws MyException {

        if (activityDTO.getDescription() == null ) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }

        ActivityDTO savedActivityDTO = activityService.createActivity(activityDTO);
        String idActivity = activityDTO.getIdActivity();

        taskService.addActivityToTask(idTask,idActivity);

        return ResponseEntity.status(HttpStatus.OK).body(activityDTO);
    }

    @GetMapping("/{idActivity}")
    public ResponseEntity<ActivityDTO> findActivityById(@PathVariable String idActivity){
        ActivityDTO activityDTO = activityService.findActivityById(idActivity);

        if (activityDTO != null){
            return ResponseEntity.status(HttpStatus.OK).body(activityDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/update/{idActivity}")
    public ResponseEntity<ActivityDTO> updateActivity(@PathVariable String idActivity, @RequestBody ActivityDTO updatedActivityDTO) throws MyException{
        ActivityDTO activityDTO = activityService.updateActivity(idActivity, updatedActivityDTO);
        
        if(updatedActivityDTO.getDescription()==null || activityDTO.getIdActivity()== null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        
        return ResponseEntity.status(HttpStatus.OK).body(activityDTO);
    }

    @PutMapping("/disable/{idActivity}")
    public ResponseEntity<ActivityDTO> disableActivity(@PathVariable String idActivity) {
        ActivityDTO activityDTO = activityService.findActivityById(idActivity);
        ActivityDTO disabledActivityDTO = activityService.disableActivity(idActivity);

        if (activityDTO != null) {
            return ResponseEntity.status(HttpStatus.OK).body(disabledActivityDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/enable/{idActivity}")
    public ResponseEntity<ActivityDTO> enableActivity(@PathVariable String idActivity) {
        ActivityDTO activityDTO = activityService.findActivityById(idActivity);
        ActivityDTO enabledActivityDTO = activityService.enableActivity(idActivity);

        if (activityDTO != null) {
            return ResponseEntity.status(HttpStatus.OK).body(enabledActivityDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
