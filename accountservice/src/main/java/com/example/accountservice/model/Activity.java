package com.example.accountservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
    private Integer id;
    private String name;
    private String description;
    private Long createdAt;
    private String createdBy;
}
