package com.example.activityservice.controller;

import com.example.activityservice.service.ActivityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

@WebMvcTest
@ExtendWith(SpringExtension.class)
public class ActivityControllerIntegrationTest {

    @MockBean
    ActivityService activityService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void getActivityShouldReturnActivityList() throws Exception {
        Mockito.when(activityService.getAll()).thenReturn(Collections.emptyList());
//        Mockito.when(activityService.getAll()).thenThrow(NullPointerException.class);

        ResultActions actual = mockMvc.perform(MockMvcRequestBuilders.get("/activity"));
        actual.andExpect(MockMvcResultMatchers.status().isOk());
        actual.andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}
