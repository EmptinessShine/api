package com.taskflow.api.controller;

import com.taskflow.api.dto.TaskRequest;
import com.taskflow.api.dto.TaskResponse;
import com.taskflow.api.entity.Task;
import com.taskflow.api.exception.ResourceNotFoundException;
import com.taskflow.api.mapper.TaskMapper;
import com.taskflow.api.repository.TaskRepository;
import com.taskflow.api.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    private final TaskMapper taskMapper;
    private final TaskRepository taskRepository;

    @PostMapping()
    public TaskResponse create(@Valid @RequestBody TaskRequest taskRequest) {
        return taskMapper.toResponse(taskService.createTask(taskRequest));
    }

    @GetMapping()
    public java.util.List<TaskResponse> getAll() {
        return taskService.getAll().stream()
                .map(taskMapper::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        if (!taskRepository.existsById(id)){
            throw new ResourceNotFoundException("Task with id: " + id + " not found");
        }
        taskService.deleteTask(id);

    }

    @PutMapping("/{id}")
    public TaskResponse update(@PathVariable Long id, @Valid @RequestBody TaskRequest request) {
        return taskMapper.toResponse(taskService.updateTask(id,request));
    }

    @PatchMapping("/{id}")
    public TaskResponse markAsDone(@PathVariable Long id) {
        return taskMapper.toResponse(taskService.closeTask(id));
    }


}
