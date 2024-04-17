package com.example.taskmanagement.dto.request;

import com.example.taskmanagement.model.enums.TaskStatus;
import lombok.Data;

@Data
public class TaskUpdateRequestDto {
    private TaskStatus status;
}
