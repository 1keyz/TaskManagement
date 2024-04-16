package com.example.taskmanagement.service.impl;

import com.example.taskmanagement.config.PasswordEncoderConfig;
import com.example.taskmanagement.core.utils.exception.types.BusinessException;
import com.example.taskmanagement.dto.request.LoginRequestDto;
import com.example.taskmanagement.dto.request.RegisterRequestDto;
import com.example.taskmanagement.dto.response.RegisterResponse;
import com.example.taskmanagement.dto.response.UserDto;
import com.example.taskmanagement.model.entity.User;
import com.example.taskmanagement.repository.UserRepository;
import com.example.taskmanagement.service.abstracts.UserService;
import com.example.taskmanagement.service.mappers.UserMapper;
import com.example.taskmanagement.service.abstracts.AuthService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private UserRepository repository;
    private ModelMapper modelMapper;
    private PasswordEncoderConfig passwordEncoderConfig;
    private UserService userService;
    @Override
    public RegisterResponse register(RegisterRequestDto requestDto) {
        User user = UserMapper.INSTANCE.UserFromUserRequestDto(requestDto);
      
        user.setPassword(passwordEncoderConfig.bCryptPasswordEncoder().encode(user.getPassword()));
        repository.save(user);

        UserDto userDto = modelMapper.map( repository.save(user),UserDto.class);
        return modelMapper.map(userDto, RegisterResponse.class);
    }

    @Override
    public String login(LoginRequestDto requestDto) {
        User foundUser = repository.findByEmail(requestDto.getEmail());

        boolean passwordMatches = passwordEncoderConfig.bCryptPasswordEncoder().matches(requestDto.getPassword(),foundUser.getPassword());
        if (passwordMatches){
            return "login succesful";
        }

       /* if (!foundUser.getPassword().equals(requestDto.getPassword())){
            return new BusinessException("Email and password not exist").toString();
        }
        return "Login succesful";
        */
        return new BusinessException("Email and password not exist").toString();
    }

    @Override
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object ob = authentication.getPrincipal();
        if (authentication != null && authentication.isAuthenticated()){
            User user = userService.getByEmail(ob.toString());
            return user;
        }
        return null;
    }

    public User findUserById(long id){
        return repository.findById(id).orElseThrow(
                () -> new BusinessException("user not found"));
    }
}
