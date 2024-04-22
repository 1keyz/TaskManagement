package com.example.taskmanagement.converter;

import com.example.taskmanagement.dto.response.UserResponseDto;
import com.example.taskmanagement.model.entity.User;
import com.example.taskmanagement.service.mappers.UserMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserDtoConverter implements Converter<User, UserResponseDto> {
    private UserVerificationDtoConverter verificationDtoConverter;
    @Override
    public UserResponseDto convert(MappingContext<User, UserResponseDto> context) {
        return convert(context.getSource());
    }

    public UserResponseDto convert(User user) {
        UserResponseDto userResponseDto = UserMapper.INSTANCE.userDtoFromUser(user);
        userResponseDto.setUserVerification(verificationDtoConverter.convertList(user.getUserVerification()));
        return userResponseDto;
    }
}
