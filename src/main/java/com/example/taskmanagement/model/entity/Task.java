package com.example.taskmanagement.model.entity;

import com.example.taskmanagement.model.enums.Enum;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "task")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Task extends AbstractDateModel {
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Enum status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project assignedProject;

    @Column(name = "assigned_user")
    private int assignedUser = 1;

}
