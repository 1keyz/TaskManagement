package com.example.taskmanagement.controller;

import com.example.taskmanagement.dto.request.AssignTaskToProjectRequest;
import com.example.taskmanagement.dto.request.TaskRequestDto;
import com.example.taskmanagement.dto.request.TaskUpdateRequestDto;
import com.example.taskmanagement.dto.response.TaskDto;
import com.example.taskmanagement.service.abstracts.TaskService;
import com.example.taskmanagement.service.impl.TaskServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {
    private TaskService taskServiceImpl;

    public TaskController(TaskServiceImpl taskServiceImpl) {
        this.taskServiceImpl = taskServiceImpl;
    }

    @PostMapping
    public TaskDto create(@RequestBody TaskRequestDto requestDto){
       return taskServiceImpl.create(requestDto);
    }
    @PutMapping("/{id}")
    public TaskDto update(@PathVariable long id ,@RequestBody TaskUpdateRequestDto requestDto){
        return taskServiceImpl.update(id,requestDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        taskServiceImpl.delete(id);
    }

    @PutMapping("/assign")
    public TaskDto addProjectToTask(@RequestBody AssignTaskToProjectRequest request){
        return taskServiceImpl.addProjectToTask(request);
    }
}
