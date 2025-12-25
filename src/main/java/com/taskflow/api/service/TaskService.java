package com.taskflow.api.service;


import com.taskflow.api.dto.TaskRequest;
import com.taskflow.api.entity.Task;
import com.taskflow.api.entity.TaskStatus;
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
    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

    public Task updateTask(Long id, TaskRequest request){
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task now found"));
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        return taskRepository.save(task);
    }

    public Task closeTask(Long id){
        Task task = taskRepository.findById(id).orElseThrow(()-> new RuntimeException("Task not found"));

        task.setStatus(TaskStatus.DONE);
        return taskRepository.save(task);
    }

}
