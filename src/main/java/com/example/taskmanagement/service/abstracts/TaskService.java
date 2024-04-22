package com.example.taskmanagement.service.abstracts;

import com.example.taskmanagement.dto.request.AssignTaskToProjectRequest;
import com.example.taskmanagement.dto.request.TaskRequestDto;
import com.example.taskmanagement.dto.request.TaskUpdateRequestDto;
import com.example.taskmanagement.dto.response.TaskResponseDto;
import com.example.taskmanagement.model.entity.Task;

import java.util.List;

public interface TaskService {
    TaskResponseDto addProjectToTask(AssignTaskToProjectRequest request);
    TaskResponseDto create(TaskRequestDto requestDto);
    TaskResponseDto update(long id , TaskUpdateRequestDto updateRequestDto);
    void delete(long id);
    List<Task> getAll();
    List<TaskResponseDto> getTaskByProjectId(long projectId);
    TaskResponseDto assignedUserToTask(long id, long userId);
    //Task findByTaskWithId(long id);
    // Task update(Task task);
}
