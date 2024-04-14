package com.example.taskmanagement.service.abstracts;

import com.example.taskmanagement.dto.response.UserDto;
import com.example.taskmanagement.model.entity.User;
import org.springframework.web.bind.annotation.PathVariable;

public interface UserService {
    User getByUserWithEmail(String email);
    User getByUserWithId(long id);
    UserDto getUserById(long id);
}
