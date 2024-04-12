package com.example.taskmanagement.service.abstracts;

import com.example.taskmanagement.model.entity.User;

public interface UserService {
    User getByUserWithEmail(String email);
}
