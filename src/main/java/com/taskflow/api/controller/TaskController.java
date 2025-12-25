package com.taskflow.api.controller;

import com.taskflow.api.dto.TaskRequest;
import com.taskflow.api.entity.Task;
import com.taskflow.api.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
private final TaskService taskService;

@PostMapping()
public Task create(@Valid @RequestBody TaskRequest taskRequest){
    return taskService.createTask(taskRequest);
}

@GetMapping()
public java.util.List<Task> getAll(){
    return taskService.getAll();
}

@DeleteMapping("/{id}")
public void delete(@PathVariable Long id){
    taskService.deleteTask(id);
}
@PutMapping("/{id}")
public Task update(@PathVariable Long id, @Valid @RequestBody TaskRequest request){
    return taskService.updateTask(id,request);
}

@PatchMapping("/{id}")
public Task markAsDone(@PathVariable Long id){
    return taskService.closeTask(id);
}



}
