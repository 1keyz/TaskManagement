package com.example.taskmanagement.converter;

import com.example.taskmanagement.dto.response.UserDto;
import com.example.taskmanagement.model.entity.User;
import com.example.taskmanagement.service.mappers.UserMapper;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter implements Converter<User, UserDto> {
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

        UserDto userDto1 = UserMapper.INSTANCE.userDtoFromUser(user);
        return userDto1;
    }
}
