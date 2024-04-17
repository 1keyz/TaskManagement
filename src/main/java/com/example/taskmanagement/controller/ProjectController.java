package com.example.taskmanagement.controller;

import com.example.taskmanagement.dto.request.ProjectRequestDto;
import com.example.taskmanagement.dto.request.ProjectUpdateRequest;
import com.example.taskmanagement.dto.response.ProjectDto;
import com.example.taskmanagement.service.abstracts.ProjectService;
import com.example.taskmanagement.service.impl.ProjectServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
@AllArgsConstructor
@Slf4j
public class ProjectController {
    private ProjectService projectService;


    @PostMapping("/create")
    public ResponseEntity<ProjectDto> createProject(@RequestBody ProjectRequestDto projectRequestDto) {
       return ResponseEntity.ok(projectService.createProject(projectRequestDto));
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable long id) {
        projectService.deleteProject(id);
        log.info("project deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDto> updateProject(@RequestParam long id , @RequestBody ProjectUpdateRequest updateRequest) {
       return ResponseEntity.ok(projectService.updateProject(id,updateRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getProjectById(@PathVariable long id){
        return ResponseEntity.ok(projectService.getProjectById(id));
    }
}
