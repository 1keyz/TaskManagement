package com.example.taskmanagement.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@MappedSuperclass
public abstract class AbstractDateModel extends AbstractIdModel {
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;


    public AbstractDateModel(){
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }


}
