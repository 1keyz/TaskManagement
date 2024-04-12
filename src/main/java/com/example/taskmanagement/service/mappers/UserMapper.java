package com.example.taskmanagement.service.mappers;

import com.example.taskmanagement.dto.request.RegisterRequestDto;
import com.example.taskmanagement.dto.response.UserDto;
import com.example.taskmanagement.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDto userDtoFromUser(User user);
    User UserFromUserRequestDto(RegisterRequestDto requestDto);
}
