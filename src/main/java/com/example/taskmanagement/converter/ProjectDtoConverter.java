package com.example.taskmanagement.converter;

import com.example.taskmanagement.dto.response.ProjectResponseDto;
import com.example.taskmanagement.dto.response.TaskResponseDto;
import com.example.taskmanagement.model.entity.Project;
import lombok.AllArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ProjectDtoConverter implements Converter<Project, ProjectResponseDto> {
    private TaskDtoConverter taskDtoConverter;

    @Override
    public ProjectResponseDto convert(MappingContext<Project, ProjectResponseDto> context) {
        return convert(context.getSource());
    }

    public ProjectResponseDto convert(Project project) {
        ProjectResponseDto projectResponseDto = new ProjectResponseDto();
        if (project.getTaskList() != null){
            List<TaskResponseDto> taskResponseDtoList = project.getTaskList().stream().map(taskDtoConverter :: convert).collect(Collectors.toList());
            projectResponseDto.setTaskResponseDtoList(taskResponseDtoList);
        }
        else projectResponseDto.setTaskResponseDtoList(null);
        projectResponseDto.setName(project.getName());
       // projectDto.setCreatedBy(project.getCreatedBy());
        return projectResponseDto;
    }
}
