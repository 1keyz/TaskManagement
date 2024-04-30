package com.example.taskmanagement.service.impl;

import com.example.taskmanagement.core.utils.exception.types.NotFoundException;
import com.example.taskmanagement.dto.request.ProjectRequestDto;
import com.example.taskmanagement.dto.request.ProjectUpdateRequest;
import com.example.taskmanagement.dto.response.ProjectResponseDto;
import com.example.taskmanagement.model.entity.Project;
import com.example.taskmanagement.repository.ProjectRepository;
import com.example.taskmanagement.service.abstracts.AuthService;
import com.example.taskmanagement.service.abstracts.ProjectService;
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
    private TaskServiceImpl taskService;
    private AuthService authService;


    @Override
    public ProjectResponseDto createProject(ProjectRequestDto projectRequestDto) {
        Project project = Project.builder()
                .name(projectRequestDto.getName())
                .createdBy(authService.getCurrentUser().getId())
                .build();
        return mapper.map(projectRepository.save(project), ProjectResponseDto.class);
    }


    @Override
    public void deleteProject(long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public ProjectResponseDto updateProject(long id , ProjectUpdateRequest updateRequest) {
        Project project = findByProjectId(id);
        project.setName(updateRequest.getName());
        project.setUpdatedAt(LocalDateTime.now());
        return mapper.map(projectRepository.save(project), ProjectResponseDto.class);
    }

    @Override
    public ProjectResponseDto getProjectById(long id) {
        return mapper.map(projectRepository.getById(id), ProjectResponseDto.class);
    }

    @Override
    public Project getByProject(long id){
        Project project = projectRepository.getById(id);
        return project;
    }

    @Override
    public Project findByProjectId(long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("project not found"));
    }
}
