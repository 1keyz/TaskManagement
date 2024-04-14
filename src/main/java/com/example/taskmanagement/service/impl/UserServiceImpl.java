package com.example.taskmanagement.service.impl;

import com.example.taskmanagement.model.entity.User;
import com.example.taskmanagement.repository.UserRepository;
import com.example.taskmanagement.service.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    @Override
    public User getByUserWithEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public User getCurrentUser() { // project.createdBy'ı bu method ile setliyoruz içerisinden useri bulup dönderiyoruz
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Object ob = authentication.getPrincipal();
        if (authentication != null && authentication.isAuthenticated()){
            User user = getByUserWithEmail(ob.toString());
            return user;
        }
        return null;
    }
}
