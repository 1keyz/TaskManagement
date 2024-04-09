package com.example.taskmanagement.converter;

import com.example.taskmanagement.dto.response.RegisterResponse;
import com.example.taskmanagement.dto.response.UserDto;
import com.example.taskmanagement.model.entity.User;
import lombok.AllArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RegisterResponseConverter implements Converter<UserDto, RegisterResponse> {

    @Override
    public RegisterResponse convert(MappingContext<UserDto, RegisterResponse> context) {
        return convert(context.getSource());
    }

    public RegisterResponse convert(UserDto userDto) {
        RegisterResponse response = RegisterResponse.builder()
                .userDto(userDto)
                .build();
        return response;
    }
}
