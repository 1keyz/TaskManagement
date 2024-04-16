package com.example.taskmanagement.security.serviceimple;

import com.example.taskmanagement.model.entity.User;
import com.example.taskmanagement.security.CustomerUserDetails;
import com.example.taskmanagement.service.abstracts.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class UserDetailsServiceImple implements UserDetailsService {
    private UserService userService;

    public UserDetailsServiceImple(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getByEmail(username);
        return new CustomerUserDetails(user);
    }
}
