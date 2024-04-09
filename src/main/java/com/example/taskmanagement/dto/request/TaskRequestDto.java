package com.example.taskmanagement.dto.request;

import com.example.taskmanagement.model.enums.Enum;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequestDto {
    private String name;
    private String description;
    private Enum status;
    @NotBlank(message = "Proje ataması olmadan task kaydedilemez!")
    private long projectId;

}
