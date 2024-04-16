package com.example.taskmanagement.model.entity;

import com.example.taskmanagement.model.enums.TaskStatus;
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
    private TaskStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignedProject")
    private Project assignedProject;

    //@Column(name = "assigned_user")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assigned_user")
    private User assignedUser;

}
