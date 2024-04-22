package com.example.taskmanagement.service.impl;

import com.example.taskmanagement.config.PasswordEncoderConfig;
import com.example.taskmanagement.core.utils.exception.types.BusinessException;
import com.example.taskmanagement.dto.request.LoginRequestDto;
import com.example.taskmanagement.dto.request.RegisterRequestDto;
import com.example.taskmanagement.dto.response.LoginResponseDto;
import com.example.taskmanagement.dto.response.RegisterResponseDto;
import com.example.taskmanagement.dto.response.UserResponseDto;
import com.example.taskmanagement.model.entity.User;
import com.example.taskmanagement.model.entity.UserVerification;
import com.example.taskmanagement.model.enums.UserStatus;
import com.example.taskmanagement.repository.UserRepository;
import com.example.taskmanagement.service.abstracts.UserService;
import com.example.taskmanagement.service.abstracts.UserVerificationService;
import com.example.taskmanagement.service.mappers.UserMapper;
import com.example.taskmanagement.service.abstracts.AuthService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private UserRepository repository;
    private ModelMapper modelMapper;
    private PasswordEncoderConfig passwordEncoderConfig;
    private UserService userService;
    private UserVerificationService userVerificationService;
    @Override
    public RegisterResponseDto register(RegisterRequestDto requestDto) {
        User user = UserMapper.INSTANCE.UserFromUserRequestDto(requestDto);
        user.setPassword(passwordEncoderConfig.bCryptPasswordEncoder().encode(user.getPassword()));

        List<UserVerification> userVerificationList = new ArrayList<>();
        userVerificationList.add(userVerificationService.createCode(user));
        user.setUserStatus(UserStatus.WAITING_FOR_VERIFICATION);
        user.setUserVerification(userVerificationList);


        UserResponseDto userResponseDto = modelMapper.map( repository.save(user), UserResponseDto.class);
        return modelMapper.map(userResponseDto, RegisterResponseDto.class);
    }

    @Override
    public LoginResponseDto login(LoginRequestDto requestDto) {
        User foundUser = repository.findByEmail(requestDto.getEmail());

        boolean passwordMatches = passwordEncoderConfig.bCryptPasswordEncoder().matches(requestDto.getPassword(),foundUser.getPassword());
        if (!passwordMatches){
            throw new BusinessException("Giriş başarısız");
        }
        LoginResponseDto loginResponseDto = LoginResponseDto.builder()
                .email(requestDto.getEmail())
                .message("login succesful")
                .build();

        return loginResponseDto;
    }

    @Override
    public User getCurrentUser() { // authanticated olmuş kullanıcıyı çektiğimiz method şu anlık sadece createdByProject kısmında createdBy'ı setlemek için kullanıyorum
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
