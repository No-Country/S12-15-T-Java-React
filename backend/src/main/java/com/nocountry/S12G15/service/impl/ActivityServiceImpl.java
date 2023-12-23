package com.nocountry.S12G15.service.impl;

import com.nocountry.S12G15.domain.entity.ActivityEntity;
import com.nocountry.S12G15.dto.ActivityDTO;
import com.nocountry.S12G15.exception.ExceptionMethods;
import com.nocountry.S12G15.exception.MyException;
import com.nocountry.S12G15.mapper.ActivityMapper;
import com.nocountry.S12G15.mapper.TaskMapper;
import com.nocountry.S12G15.persistance.repository.ActivityRepository;
import com.nocountry.S12G15.persistance.repository.TaskRepository;
import com.nocountry.S12G15.persistance.repository.UserRepository;
import com.nocountry.S12G15.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    UserRepository userRepository;

    @Override
    public ActivityDTO createActivity(ActivityDTO activityDTO, String idUser) throws MyException {
        validate(activityDTO);

        //Hay que ver el retorno del UserResponseDTO
        ActivityEntity activity = activityMapper.activityDTOToActivity(activityDTO);
        activity.setEnabled(true);

        String username = userRepository.findById(idUser).get().getRealUserName();
        activity.setUsername(username);
        ActivityEntity savedActivity = activityRepository.save(activity);

        return activityMapper.activityToActivityDTO(savedActivity);

    }

    @Override
    public Optional<List<ActivityDTO>> getAllActivities() {

        return Optional.of(activityMapper.toActivityDtoList(activityRepository.findAll()));

    }

    @Override
    public List<ActivityDTO> getEnabledActivities() {
        List<ActivityDTO> activitiesDTO = getAllActivities().orElseThrow();

        return activitiesDTO.stream().filter(ActivityDTO::isEnabled).collect(Collectors.toList());
    }

    @Override
    public ActivityDTO findActivityById(String idActivity) {

        ActivityEntity activity = activityRepository.findById(idActivity).orElseThrow();

        return activityMapper.activityToActivityDTO(activity);

    }

    @Override
    public ActivityDTO updateActivity(String idActivity, ActivityDTO updatedActivityDTO) throws MyException {

        validate(updatedActivityDTO);

        ActivityEntity activity = activityRepository.findById(idActivity).orElseThrow();

        ActivityEntity savedActivity = activityRepository.save(activity);

        return activityMapper.activityToActivityDTO(savedActivity);

    }

    @Override
    public ActivityDTO disableActivity(String idActivity) {

        ActivityEntity activity = activityRepository.findById(idActivity).orElseThrow();

        activity.setEnabled(false);
        ActivityEntity savedActivity = activityRepository.save(activity);

        return activityMapper.activityToActivityDTO(savedActivity);

    }

    @Override
    public ActivityDTO enableActivity(String idActivity) {

        ActivityEntity activity = activityRepository.findById(idActivity).orElseThrow();

        activity.setEnabled(true);

        ActivityEntity savedActivity = activityRepository.save(activity);

        return activityMapper.activityToActivityDTO(savedActivity);

    }

    private void validate(ActivityDTO activityDTO) throws MyException {

        if (activityDTO.getName()== null || ExceptionMethods.onlySpaces(activityDTO.getDescription())) {
            throw new MyException("Activity's name can't be null or empty.");
        }
    }
}
