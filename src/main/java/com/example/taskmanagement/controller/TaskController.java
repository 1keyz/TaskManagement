package com.example.taskmanagement.controller;

import com.example.taskmanagement.dto.request.AssignTaskToProjectRequest;
import com.example.taskmanagement.dto.request.TaskRequestDto;
import com.example.taskmanagement.dto.request.TaskUpdateRequestDto;
import com.example.taskmanagement.dto.response.TaskResponseDto;
import com.example.taskmanagement.service.abstracts.TaskService;
import com.example.taskmanagement.service.impl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<TaskResponseDto> create(@RequestBody TaskRequestDto requestDto){
       return ResponseEntity.ok(taskService.create(requestDto));
    }
    @PutMapping("/{ids}")
    public ResponseEntity<TaskResponseDto> update(@PathVariable long ids , @RequestBody TaskUpdateRequestDto requestDto){
        return ResponseEntity.ok(taskService.update(ids,requestDto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        taskService.delete(id);
    }

    @PutMapping("/assign")
    public ResponseEntity<TaskResponseDto> addProjectToTask(@RequestBody AssignTaskToProjectRequest request){
        return ResponseEntity.ok(taskService.addProjectToTask(request));
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<List<TaskResponseDto>> getTaskByProjectId(@PathVariable long projectId){
        return ResponseEntity.ok(taskService.getTaskByProjectId(projectId));
    }

    @PutMapping("/{idd}")
    public ResponseEntity<TaskResponseDto> assignUserToTask(@PathVariable long idd , long userId){
        return ResponseEntity.ok(taskService.assignedUserToTask(idd,userId));
    }
}
