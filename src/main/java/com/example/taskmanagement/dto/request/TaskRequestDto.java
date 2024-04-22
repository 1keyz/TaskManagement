package com.example.taskmanagement.dto.request;

import com.example.taskmanagement.model.enums.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequestDto {
    @NotBlank(message = "Task ismi boş olamaz!")
    private String name;
    private String description;
    @NotBlank(message = "Task status boş olamaz!")
    private TaskStatus status;
    @NotBlank(message = "Proje ismi boş olamaz!")
    private long projectId;
    private long userId;
}
