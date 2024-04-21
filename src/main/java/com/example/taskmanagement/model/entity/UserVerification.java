package com.example.taskmanagement.model.entity;

import com.example.taskmanagement.dto.response.MailResponse;
import jakarta.persistence.*;
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
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "userl")
    private User userl;
    private String code;
    private LocalDateTime expirationTime;
    private boolean verified = false;
}
