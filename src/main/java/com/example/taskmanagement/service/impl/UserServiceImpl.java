package com.example.taskmanagement.service.impl;

import com.example.taskmanagement.dto.response.UserDto;
import com.example.taskmanagement.model.entity.User;
import com.example.taskmanagement.repository.UserRepository;
import com.example.taskmanagement.service.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final ModelMapper mapper;
    
    @Override
    public User getByEmail(String email) {
        return repository.findByEmail(email);
    }

    public User getById(long id){
        return repository.getById(id);
    }

    @Override
    public UserDto getUserDetailsById(long id) {
        return mapper.map(repository.getById(id),UserDto.class);
    }
}
