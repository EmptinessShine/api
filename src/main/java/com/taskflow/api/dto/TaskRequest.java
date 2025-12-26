package com.taskflow.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class TaskRequest {
    @NotBlank
    private String title;
    private String description;
    private String status;
    private Long categoryId;
}
