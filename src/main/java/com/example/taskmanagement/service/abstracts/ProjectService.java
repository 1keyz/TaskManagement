package com.example.taskmanagement.service.abstracts;

import com.example.taskmanagement.dto.request.ProjectRequestDto;
import com.example.taskmanagement.dto.request.ProjectUpdateRequest;
import com.example.taskmanagement.dto.response.ProjectResponseDto;
import com.example.taskmanagement.model.entity.Project;

public interface ProjectService {
    ProjectResponseDto createProject(ProjectRequestDto projectRequestDto);
    void deleteProject(long id);
    ProjectResponseDto updateProject( ProjectUpdateRequest updateRequest);

    ProjectResponseDto getProjectById(long id);
    Project findByProjectId(long id);
    Project getByProject(long id);
}
