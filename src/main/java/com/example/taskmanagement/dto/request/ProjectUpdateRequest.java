package com.example.taskmanagement.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProjectUpdateRequest {
    private long id;
    @NotNull(message = "Proje ismi bos olamaz!")
    private String name;
}
