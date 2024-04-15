package com.example.taskmanagement.converter;

import com.example.taskmanagement.dto.response.TaskDto;
import com.example.taskmanagement.dto.response.UserDto;
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
    private UserDtoConverter userDtoConverter;

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
        if (task.getAssignedProject() != null){
            taskDto.setTaskProjectDto(taskProjectDtoConverter.convert(task.getAssignedProject()));
        }
        taskDto.setAssignUser(userDtoConverter.convert(task.getAssignedUser()));
        return taskDto;
    }
}
