package com.example.accountservice.service;

import com.example.accountservice.client.ActivityServiceClient;
import com.example.accountservice.model.Account;
import com.example.accountservice.model.Activity;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ActivityService {
    private ActivityServiceClient activityServiceClient;

    public ActivityService(ActivityServiceClient activityServiceClient) {
        this.activityServiceClient = activityServiceClient;
    }

    public List<Activity> getUserActivity(Account account) {
        String url = "http://localhost:8000/activity/" + account.getUser();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Activity>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Activity>>() {});

        List<Activity> activities = response.getBody();
        return activities;
    }

    public List<Activity> getUserActivityByFeign(Account account) {
        return activityServiceClient.getActivityFromUser(account.getUser());
    }
}
