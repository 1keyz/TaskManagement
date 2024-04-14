package com.example.taskmanagement.service.impl;

import com.example.taskmanagement.core.utils.exception.types.BusinessException;
import com.example.taskmanagement.dto.request.ProjectRequestDto;
import com.example.taskmanagement.dto.request.ProjectUpdateRequest;
import com.example.taskmanagement.dto.response.ProjectDto;
import com.example.taskmanagement.model.entity.Project;
import com.example.taskmanagement.repository.ProjectRepository;
import com.example.taskmanagement.service.abstracts.ProjectService;
import com.example.taskmanagement.service.abstracts.TaskService;
import com.example.taskmanagement.service.abstracts.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Slf4j
public class ProjectServiceImpl implements ProjectService {
    private ProjectRepository projectRepository;
    private ModelMapper mapper;
    private TaskService taskService;
    private UserService userService;


    @Override
    public ProjectDto createProject(ProjectRequestDto projectRequestDto) {
        Project project = Project.builder()
                .name(projectRequestDto.getName())
                .createdBy(userService.getCurrentUser().getId())
                .build();
        //project.setCreatedBy(userService.getCurrentUser().getId());
        return mapper.map(projectRepository.save(project),ProjectDto.class);
    }

    @Override
    public void setCreatedBy(long id , long projectId){
        Project project = findByProjectId(projectId);
        project.setCreatedBy(id);
    }


    @Override
    public void deleteProject(long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public ProjectDto updateProject(long id , ProjectUpdateRequest updateRequest) {
        Project project = findByProjectId(id);
        project.setName(updateRequest.getName());
        project.setUpdatedAt(LocalDateTime.now());
        return mapper.map(projectRepository.save(project),ProjectDto.class);
    }

    @Override
    public Project findByProjectId(long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new BusinessException("project not found"));
    }
}
