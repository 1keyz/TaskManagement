package com.example.taskmanagement.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProjectUpdateRequest {
    @NotNull(message = "Proje ismi bos olamaz!")
    private String name;
}
