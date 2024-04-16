package com.example.taskmanagement.controller;

import com.example.taskmanagement.dto.request.AssignTaskToProjectRequest;
import com.example.taskmanagement.dto.request.TaskRequestDto;
import com.example.taskmanagement.dto.request.TaskUpdateRequestDto;
import com.example.taskmanagement.dto.response.TaskDto;
import com.example.taskmanagement.service.abstracts.TaskService;
import com.example.taskmanagement.service.impl.TaskServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    private TaskService taskService;

    @Autowired
    public TaskController(TaskServiceImpl taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/create")
    public TaskDto create(@RequestBody TaskRequestDto requestDto){
       return taskService.create(requestDto);
    }
    @PutMapping("/{ids}")
    public TaskDto update(@PathVariable long ids ,@RequestBody TaskUpdateRequestDto requestDto){
        return taskService.update(ids,requestDto);
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

    @PutMapping("/{idd}")
    public TaskDto assignUserToTask(@PathVariable long idd , long userId){
        return taskService.assignUserToTask(idd,userId);
    }
}
