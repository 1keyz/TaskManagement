package com.example.taskmanagement.converter;

import com.example.taskmanagement.dto.response.TaskDto;
import com.example.taskmanagement.model.entity.Task;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TaskDtoConverter implements Converter<Task, TaskDto> {

    private TaskProjectDtoConverter taskProjectDtoConverter;

    @Override
    public TaskDto convert(MappingContext<Task, TaskDto> context) {
       return convert(context.getSource());
    }
    public TaskDto convert(Task task) {
        TaskDto taskDto = TaskDto.builder()
                .name(task.getName())
                .description(task.getDescription())
                .status(task.getStatus())
                .build();
        taskDto.setTaskProjectDto(taskProjectDtoConverter.convert(task.getAssignedProject()));
        return taskDto;
    }
}
