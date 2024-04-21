package com.example.taskmanagement.config;

import com.example.taskmanagement.converter.*;
import com.example.taskmanagement.dto.response.UserVerificationDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class MapperConfig {
    private TaskDtoConverter taskDtoConverter;
    private TaskProjectDtoConverter taskProjectDtoConverter;
    private UserDtoConverter userDtoConverter;
    private UserVerificationDtoConverter userVerificationDtoConverter;

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addConverter(new TaskDtoConverter(taskProjectDtoConverter,userDtoConverter));
        modelMapper.addConverter(new ProjectDtoConverter(taskDtoConverter));
        modelMapper.addConverter(new TaskProjectDtoConverter());
        modelMapper.addConverter(new UserDtoConverter(userVerificationDtoConverter));
        modelMapper.addConverter(new UserVerificationDtoConverter());
        return modelMapper;
    }
}
