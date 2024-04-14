package com.example.taskmanagement.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class ProjectDto {
    private String name;
    //private long createdBy;
    private List<TaskDto> taskDtoList;
}
