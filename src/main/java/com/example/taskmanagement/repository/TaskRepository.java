package com.example.taskmanagement.repository;

import com.example.taskmanagement.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query(value = "select * from task  where Task.assigned_project =:projectId" , nativeQuery = true)
    List<Task> getTaskByProjectId(@Param("projectId") long projectId);
}
