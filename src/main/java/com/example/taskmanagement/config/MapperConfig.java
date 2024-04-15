package com.example.taskmanagement.config;

import com.example.taskmanagement.converter.ProjectDtoConverter;
import com.example.taskmanagement.converter.TaskDtoConverter;
import com.example.taskmanagement.converter.TaskProjectDtoConverter;
import com.example.taskmanagement.converter.UserDtoConverter;
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

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addConverter(new TaskDtoConverter(taskProjectDtoConverter,userDtoConverter));
        modelMapper.addConverter(new ProjectDtoConverter(taskDtoConverter));
        modelMapper.addConverter(new TaskProjectDtoConverter());
        modelMapper.addConverter(new UserDtoConverter());
        return modelMapper;
    }
}
