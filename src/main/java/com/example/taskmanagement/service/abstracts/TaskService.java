package com.example.taskmanagement.service.abstracts;

import com.example.taskmanagement.dto.request.AssignTaskToProjectRequest;
import com.example.taskmanagement.dto.request.TaskRequestDto;
import com.example.taskmanagement.dto.request.TaskUpdateRequestDto;
import com.example.taskmanagement.dto.response.TaskDto;
import com.example.taskmanagement.model.entity.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    TaskDto addProjectToTask(AssignTaskToProjectRequest request);
    TaskDto create(TaskRequestDto requestDto);
    TaskDto update(long id ,TaskUpdateRequestDto updateRequestDto);
    void delete(long id);
    List<Task> getAll();
    //Task findByTaskWithId(long id);
    // Task update(Task task);
}
