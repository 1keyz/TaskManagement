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
    @NotBlank(message = "Task Name giriniz")
    private String name;
    private String description;
    @NotBlank(message = "Task Status'u belirtmeden işlem yapmayınız")
    private TaskStatus status;
    @NotBlank(message = "Proje ataması olmadan task kaydedilemez!")
    private long projectId;
    @NotNull(message = "Task'ın kim tarafından oluşturulduğunu belirtiniz")
    private long userId;
}
