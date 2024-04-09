package com.example.taskmanagement.converter;

import com.example.taskmanagement.dto.response.TaskProjectDto;
import com.example.taskmanagement.model.entity.Project;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component
public class TaskProjectDtoConverter implements Converter<Project, TaskProjectDto> {
    @Override
    public TaskProjectDto convert(MappingContext<Project, TaskProjectDto> context) {
        return convert(context.getSource());
    }

    public TaskProjectDto convert(Project project) {
        TaskProjectDto taskProjectDto = TaskProjectDto.builder()
                .name(project.getName())
                .createdBy(project.getCreatedBy())
                .build();
        return taskProjectDto;
    }
}
