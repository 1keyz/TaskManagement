package com.example.taskmanagement.converter;

import com.example.taskmanagement.dto.response.TaskResponseDto;
import com.example.taskmanagement.model.entity.Task;
import lombok.AllArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TaskDtoConverter implements Converter<Task, TaskResponseDto> {

    private TaskProjectDtoConverter taskProjectDtoConverter;
    private UserDtoConverter userDtoConverter;

    @Override
    public TaskResponseDto convert(MappingContext<Task, TaskResponseDto> context) {
       return convert(context.getSource());
    }
    public TaskResponseDto convert(Task task) {
        TaskResponseDto taskResponseDto = TaskResponseDto.builder()
                .name(task.getName())
                .description(task.getDescription())
                .status(task.getStatus())
                .build();
        if (task.getAssignedProject() != null){
            taskResponseDto.setTaskProjectDto(taskProjectDtoConverter.convert(task.getAssignedProject()));
        }
        taskResponseDto.setAssignUser(userDtoConverter.convert(task.getAssignedUser()));
        return taskResponseDto;
    }
}
