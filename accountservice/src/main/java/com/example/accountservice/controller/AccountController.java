package com.example.accountservice.controller;

import com.example.accountservice.OddException;
import com.example.accountservice.model.Account;
import com.example.accountservice.model.Activity;
import com.example.accountservice.service.ActivityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    private ActivityService activityService;

    public AccountController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @PostMapping(value = "/account/activity")
    public ResponseEntity<List<Activity>> getAccountActivity(
            @RequestHeader("USERID") String userId,
            @RequestBody Account account
    ) {
        try {
            System.out.println(userId);
            // List<Activity> activities = activityService.getUserActivity(account);
            List<Activity> activities = activityService.getUserActivityByFeign(account);
            return ResponseEntity.ok().body(activities);
        } catch (Exception e) {
            // Logging
            throw new OddException("999999", "General Error");
        }
    }

}
