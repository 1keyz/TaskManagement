package com.example.taskmanagement.controller;

import com.example.taskmanagement.dto.request.AssignTaskToProjectRequest;
import com.example.taskmanagement.dto.request.TaskRequestDto;
import com.example.taskmanagement.dto.request.TaskUpdateRequestDto;
import com.example.taskmanagement.dto.response.TaskDto;
import com.example.taskmanagement.service.abstracts.TaskService;
import com.example.taskmanagement.service.impl.TaskServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskServiceImpl taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/create")
    public TaskDto create(@RequestBody TaskRequestDto requestDto){
       return taskService.create(requestDto);
    }
    @PutMapping("/{id}")
    public TaskDto update(@PathVariable long id ,@RequestBody TaskUpdateRequestDto requestDto){
        return taskService.update(id,requestDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        taskService.delete(id);
    }

    @PutMapping("/assign")
    public TaskDto addProjectToTask(@RequestBody AssignTaskToProjectRequest request){
        return taskService.addProjectToTask(request);
    }

    @GetMapping("/{projectId}")
    public List<TaskDto> getTaskByProjectId(@PathVariable long projectId){
        return taskService.getTaskByProjectId(projectId);
    }

    @PutMapping("/{id}")
    public TaskDto assignUserToTask(@PathVariable long id , long userId){
        return taskService.assignUserToTask(id,userId);
    }
}
