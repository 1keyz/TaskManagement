package com.example.taskmanagement.service.abstracts;

import com.example.taskmanagement.dto.request.ProjectRequestDto;
import com.example.taskmanagement.dto.request.ProjectUpdateRequest;
import com.example.taskmanagement.dto.response.ProjectDto;
import com.example.taskmanagement.model.entity.Project;
import org.springframework.web.bind.annotation.PathVariable;

public interface ProjectService {
    ProjectDto createProject(ProjectRequestDto projectRequestDto);
    void deleteProject(long id);
    ProjectDto updateProject(long id , ProjectUpdateRequest updateRequest);

    ProjectDto getProjectById(long id);
    Project findByProjectId(long id);
    Project getByProject(long id);
}
