package com.example.taskmanagement.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "UserVerifications")
public class UserVerification extends AbstractDateModel {
    private int userId;
    private String code;
    private LocalDateTime expirationTime;
    private boolean verified = false;
}
