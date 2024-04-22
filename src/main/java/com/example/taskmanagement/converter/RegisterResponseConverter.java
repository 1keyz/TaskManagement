package com.example.taskmanagement.converter;

import com.example.taskmanagement.dto.response.RegisterResponseDto;
import com.example.taskmanagement.dto.response.UserResponseDto;
import lombok.AllArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RegisterResponseConverter implements Converter<UserResponseDto, RegisterResponseDto> {

    @Override
    public RegisterResponseDto convert(MappingContext<UserResponseDto, RegisterResponseDto> context) {
        return convert(context.getSource());
    }

    public RegisterResponseDto convert(UserResponseDto userResponseDto) {
        RegisterResponseDto response = RegisterResponseDto.builder()
                .userResponseDto(userResponseDto)
                .build();
        return response;
    }
}
