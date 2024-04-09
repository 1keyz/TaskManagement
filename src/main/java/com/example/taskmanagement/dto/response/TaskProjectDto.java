package com.example.taskmanagement.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskProjectDto { // Task'ın içindeki Projeyi dönüştürmek için oluşturduğum dto
    private String name;
    private long createdBy;
}
