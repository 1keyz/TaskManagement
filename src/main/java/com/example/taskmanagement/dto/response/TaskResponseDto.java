package com.example.taskmanagement.dto.response;

import com.example.taskmanagement.model.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskResponseDto {
    private String name;
    private String description;
    private TaskStatus status;
    private TaskProjectDto taskProjectDto;
    private UserResponseDto assignUser;

}
