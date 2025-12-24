package com.taskflow.api.service;


import com.taskflow.api.dto.TaskRequest;
import com.taskflow.api.entity.Task;
import com.taskflow.api.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public Task createTask(TaskRequest request) {
        return taskRepository.save(Task.builder().title(request.getTitle()).description(request.getDescription()).build());
    }

    public java.util.List<Task> getAll() {
        return taskRepository.findAll();
    }


}
