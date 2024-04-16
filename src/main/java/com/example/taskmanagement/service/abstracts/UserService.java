package com.example.taskmanagement.service.abstracts;

import com.example.taskmanagement.dto.response.UserDto;
import com.example.taskmanagement.model.entity.User;

public interface UserService {
    User getByEmail(String email);
    User getById(long id);
    UserDto getUserDetailsById(long id);
}
