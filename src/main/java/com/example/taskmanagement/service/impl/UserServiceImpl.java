package com.example.taskmanagement.service.impl;

import com.example.taskmanagement.core.utils.exception.types.BusinessException;
import com.example.taskmanagement.exception.NotFoundException;
import com.example.taskmanagement.model.entity.User;
import com.example.taskmanagement.repository.UserRepository;
import com.example.taskmanagement.service.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    @Override
    public User findByUser(String email) {
        return repository.findByEmail(email);
    }
}
