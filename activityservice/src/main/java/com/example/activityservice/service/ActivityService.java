package com.example.activityservice.service;

import com.example.activityservice.model.Activity;
import com.example.activityservice.repository.ActivityRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityService {
    private ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public List<Activity> getAll() {
//        Activity activity1 = Activity.builder()
//                .id(1)
//                .name("Logout")
//                .description("HuMan is logged Out")
//                .build();
//
//        Activity activity2 = Activity.builder()
//                .id(2)
//                .name("Login")
//                .description("HuMan is logged In")
//                .build();

        List<Activity> activities = activityRepository.findAll();

        return activities;
    }

    public List<Activity> getByUser(String username) {

        // 1: @Query
//        return activityRepository.findActivityForUser(username);

        // 2: JPQL
//        return activityRepository.findAllByCreatedByIn(List<username>);

        // 3: Query by Example
        Activity activity = Activity.builder()
                .createdBy(username)
                .build();
        Example<Activity> example = Example.of(activity);
        return activityRepository.findAll(example);
    }
}
