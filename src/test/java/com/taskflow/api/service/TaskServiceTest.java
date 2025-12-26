package com.taskflow.api.service;


import com.taskflow.api.dto.TaskRequest;
import com.taskflow.api.entity.Task;
import com.taskflow.api.mapper.TaskMapper;
import com.taskflow.api.repository.CategoryRepository;
import com.taskflow.api.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.taskflow.api.entity.TaskStatus.NEW;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;



@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {
    @Mock
    private TaskRepository taskRepository;

    @Mock
    private TaskMapper taskMapper;

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    void createTask_ShouldReturnSavedTask() {
        //given
        TaskRequest taskRequest = new TaskRequest("Test  Title", "Desc", "NEW", null);

        //before save
        Task task = Task.builder().title("Test  Title").description("Desc").status(NEW).category(null).build();

        //after save
        Task savedTask = Task.builder().id(1L).title("Test  Title").description("Desc").status(NEW).category(null).build();

        //mapper return task
        when(taskMapper.toEntity(taskRequest)).thenReturn(task);

        //repo return saved task
        when(taskRepository.save(task)).thenReturn(savedTask);

        //when
        Task result = taskService.createTask(taskRequest);

        //then
        assertEquals(1L,result.getId());
        verify(taskRepository).save(task);
    }

}
