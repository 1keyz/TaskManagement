package com.example.taskmanagement.model.entity;

import com.example.taskmanagement.model.enums.UserStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends AbstractDateModel {
    @Column(name = "firs_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "assignedUser" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Task> tasks;

    @Column(name = "user_status")
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    @OneToMany(mappedBy = "userl" , fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @Column(name = "user_verifications")
    private List<UserVerification> userVerification;

}
