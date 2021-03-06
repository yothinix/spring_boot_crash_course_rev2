package com.example.activityservice.controller;

import com.example.activityservice.model.Activity;
import com.example.activityservice.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActivityController {

    private ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping(value = "/activity")
    public List<Activity> getActivity() {
        List<Activity> activities = activityService.getAll();

        return activities;
    }

    @GetMapping(value = "/activity/{USER}")
    public List<Activity> getActivityFromUser(@PathVariable("USER") String username) {
        List<Activity> userActivities = activityService.getByUser(username);
        return userActivities;
    }
}
