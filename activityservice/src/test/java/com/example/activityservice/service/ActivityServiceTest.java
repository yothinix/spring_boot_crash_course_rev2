package com.example.activityservice.service;

import com.example.activityservice.model.Activity;
import com.example.activityservice.repository.ActivityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class ActivityServiceTest {

    @Mock
    ActivityRepository activityRepository;

    @InjectMocks
    ActivityService activityService;

    @Test
    void getAllTest() {
        Activity activity1 = new Activity();
        activity1.setName("Logout");
        activity1.setDescription("HuMan is logged Out");
        Activity activity2 = new Activity();
        List<Activity> activities = List.of(activity1, activity2);

        Mockito.when(activityRepository.findAll()).thenReturn(activities);

        List<Activity> actual = activityService.getAll();

        Assertions.assertEquals(2, actual.size());
        Assertions.assertEquals("Logout", actual.get(0).getName());
        Assertions.assertEquals("HuMan is logged Out", actual.get(0).getDescription());
    }
}