package com.example.taskmanagement.service.impl;

import com.example.taskmanagement.model.entity.User;
import com.example.taskmanagement.repository.UserRepository;
import com.example.taskmanagement.service.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    
    @Override
    public User getByUserWithEmail(String email) {
        return repository.findByEmail(email);
    }
}
