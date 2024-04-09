package com.example.taskmanagement.repository;

import com.example.taskmanagement.model.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Long> {
}
