package com.taskflow.api.dto;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TaskResponse {
    private Long id;
    private String title;
    private String description;
    private String status;
}
