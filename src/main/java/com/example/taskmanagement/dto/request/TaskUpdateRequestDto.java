package com.example.taskmanagement.dto.request;

import com.example.taskmanagement.model.enums.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TaskUpdateRequestDto {
    @NotBlank(message = "Görev durumu boş olamaz!")
    private TaskStatus status;
}
