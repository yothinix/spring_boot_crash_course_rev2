package com.example.accountservice.client;

import com.example.accountservice.model.Activity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "activity-service", url = "http://localhost:8000")
public interface ActivityServiceClient {

    @GetMapping(value = "/activity/{USER}")
    List<Activity> getActivityFromUser(@PathVariable("USER") String username);
}
