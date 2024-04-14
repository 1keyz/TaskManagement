package com.example.taskmanagement.dto.response;

import com.example.taskmanagement.model.entity.Task;
import com.example.taskmanagement.model.entity.User;
import com.example.taskmanagement.model.enums.Enum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDto {
    private String name;
    private String description;
    private Enum status;
    private TaskProjectDto taskProjectDto;
    private UserDto assignUser;
}
