package com.example.taskmanagement.converter;

import com.example.taskmanagement.dto.response.ProjectDto;
import com.example.taskmanagement.dto.response.TaskDto;
import com.example.taskmanagement.model.entity.Project;
import com.example.taskmanagement.model.entity.Task;
import lombok.AllArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ProjectDtoConverter implements Converter<Project, ProjectDto> {
    private TaskDtoConverter taskDtoConverter;

    @Override
    public ProjectDto convert(MappingContext<Project, ProjectDto> context) {
        return convert(context.getSource());
    }

    public ProjectDto convert(Project project) {
        ProjectDto projectDto = new ProjectDto();
        if (project.getTaskList() != null){
            List<TaskDto> taskDtoList = project.getTaskList().stream().map(taskDtoConverter :: convert).collect(Collectors.toList());
            projectDto.setTaskDtoList(taskDtoList);
        }
        else projectDto.setTaskDtoList(null);
        projectDto.setName(project.getName());
       // projectDto.setCreatedBy(project.getCreatedBy());
        return projectDto;
    }
}
