package com.nocountry.S12G15.service;

import com.nocountry.S12G15.dto.ActivityDTO;
import com.nocountry.S12G15.exception.MyException;

import java.util.List;
import java.util.Optional;

public interface ActivityService {

    ActivityDTO createActivity(ActivityDTO activityDTO) throws MyException;
    Optional<List<ActivityDTO>> getAllActivities();
    List<ActivityDTO> getEnabledActivities();
    ActivityDTO findActivityById(String idActivity);
    ActivityDTO  updateActivity(String idActivity, ActivityDTO updatedActivityDTO) throws MyException;
    ActivityDTO disableActivity(String idActivity);
    ActivityDTO enableActivity(String idActivity);

}
