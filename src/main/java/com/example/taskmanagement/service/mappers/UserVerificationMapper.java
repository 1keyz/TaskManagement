package com.example.taskmanagement.service.mappers;

import com.example.taskmanagement.dto.response.UserVerificationDto;
import com.example.taskmanagement.model.entity.UserVerification;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserVerificationMapper {

    UserVerificationMapper INSTANCE = Mappers.getMapper(UserVerificationMapper.class);
    UserVerificationDto UserVerificationDtoFromUserVerification(UserVerification userVerification);
}
