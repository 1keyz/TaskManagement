package com.example.taskmanagement.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AssignTaskToProjectRequest {
    private long taskId;
    private long projectId;
}
