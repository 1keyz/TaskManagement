package com.example.taskmanagement.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class ProjectRequestDto {
    @NotBlank(message = "Proje ismi boş olamaz..!")
    private String name;
    //private Long createdBy;
}
