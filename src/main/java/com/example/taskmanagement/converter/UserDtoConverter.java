package com.example.taskmanagement.converter;

import com.example.taskmanagement.dto.response.UserDto;
import com.example.taskmanagement.model.entity.User;
import com.example.taskmanagement.service.mappers.UserMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserDtoConverter implements Converter<User, UserDto> {
    private UserVerificationDtoConverter verificationDtoConverter;
    @Override
    public UserDto convert(MappingContext<User, UserDto> context) {
        return convert(context.getSource());
    }

    public UserDto convert(User user) {
       /* UserDto userDto = UserDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .build();
        */
        UserDto userDto = UserMapper.INSTANCE.userDtoFromUser(user);
        return userDto;
    }
}
