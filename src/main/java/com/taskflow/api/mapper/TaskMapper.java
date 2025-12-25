package com.taskflow.api.mapper;


import com.taskflow.api.dto.TaskRequest;
import com.taskflow.api.dto.TaskResponse;
import com.taskflow.api.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    public TaskResponse toResponse(Task task) {
        return TaskResponse.builder().title(task.getTitle()).description(task.getDescription()).id(task.getId()).status(task.getStatus().name()).build();
    }

    public Task toEntity(TaskRequest taskRequest){
    return Task.builder().title(taskRequest.getTitle()).description(taskRequest.getDescription()).build();
    }
}
