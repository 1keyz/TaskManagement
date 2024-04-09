package com.example.taskmanagement.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class ProjectRequestDto {
    private String name;
    private Long createdBy;
}
