package com.taskflow.api.service;


import com.taskflow.api.dto.TaskRequest;
import com.taskflow.api.entity.Category;
import com.taskflow.api.entity.Task;
import com.taskflow.api.entity.TaskStatus;
import com.taskflow.api.exception.ResourceNotFoundException;
import com.taskflow.api.mapper.TaskMapper;
import com.taskflow.api.repository.CategoryRepository;
import com.taskflow.api.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final CategoryRepository categoryRepository;
    private final TaskMapper taskMapper;

    public Task createTask(TaskRequest request) {
        log.info("Creating new task with title: {}", request.getTitle());
        Category category = null;
        if (request.getCategoryId() != null) {
            category = categoryRepository.findById(request.getCategoryId()).orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        }
        Task task = taskMapper.toEntity(request);
        task.setCategory(category);
        log.info("Task created successfully with ID: {} ", task.getId());
        return taskRepository.save(task);
    }

    public java.util.List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task not found"));
    }

    public void deleteTask(Long id) {
        log.warn("Deleting task with ID: {} ", id);
        taskRepository.deleteById(id);
        log.warn("Task with ID {} deleted successfully ", id);
    }

    public Task updateTask(Long id, TaskRequest request) {
        log.info("Updating task with ID: {}", id);
        Task task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task now found"));
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        log.info("Task with ID {} successfully updated", id);
        return taskRepository.save(task);
    }

    public Task closeTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        task.setStatus(TaskStatus.DONE);
        log.info("Task with ID {} marked as Done", id);
        return taskRepository.save(task);
    }

}
