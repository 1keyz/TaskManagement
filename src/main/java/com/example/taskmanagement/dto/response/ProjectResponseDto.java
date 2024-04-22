package com.example.taskmanagement.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class ProjectResponseDto {
    private String name;
    //private long createdBy;
    private List<TaskResponseDto> taskResponseDtoList;
}
