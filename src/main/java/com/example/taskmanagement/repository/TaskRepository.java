package com.example.taskmanagement.repository;

import com.example.taskmanagement.dto.response.TaskDto;
import com.example.taskmanagement.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
