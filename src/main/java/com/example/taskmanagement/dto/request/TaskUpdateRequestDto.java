package com.example.taskmanagement.dto.request;

import com.example.taskmanagement.model.enums.Enum;
import lombok.Data;

@Data
public class TaskUpdateRequestDto {
    private Enum status;
}
