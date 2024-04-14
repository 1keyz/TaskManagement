package com.example.taskmanagement.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "project")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Project extends AbstractDateModel{
    @Column(name = "name")
    private String name;

    @Column(name = "created_by")
    private Long createdBy;

    @OneToMany(mappedBy = "assignedProject")
    @Column(name = "tasks")
    private List<Task> taskList;
}
