package com.taskflow.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class TaskRequest {
    @NotBlank
    private String title;
    private String description;
    private String status;
}
