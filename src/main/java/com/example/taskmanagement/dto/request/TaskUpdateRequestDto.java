package com.example.taskmanagement.dto.request;

import com.example.taskmanagement.model.enums.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TaskUpdateRequestDto {
    @NotBlank(message = "Task status boş olamaz!")
    private TaskStatus status;
}
