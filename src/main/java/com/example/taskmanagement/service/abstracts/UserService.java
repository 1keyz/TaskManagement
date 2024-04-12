package com.example.taskmanagement.service.abstracts;

import com.example.taskmanagement.model.entity.User;

import java.util.Optional;

public interface UserService {
    User findByUser(String email);
}
