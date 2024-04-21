package com.example.taskmanagement.converter;

import com.example.taskmanagement.dto.response.UserVerificationDto;
import com.example.taskmanagement.model.entity.User;
import com.example.taskmanagement.model.entity.UserVerification;
import com.example.taskmanagement.service.mappers.UserVerificationMapper;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserVerificationDtoConverter implements Converter<UserVerification, UserVerificationDto> {


    public List<UserVerificationDto> convertList(List<UserVerification> userVerificationList) {
       List<UserVerificationDto> userVerificationDtoList = userVerificationList.stream()
               .map(x -> convert(x)).collect(Collectors.toList());
       return userVerificationDtoList;
    }

    @Override
    public UserVerificationDto convert(MappingContext<UserVerification, UserVerificationDto> context) {
        return convert(context.getSource());
    }

    public UserVerificationDto convert(UserVerification userVerification) {
        UserVerificationDto userVerificationDto = UserVerificationMapper
                .INSTANCE.UserVerificationDtoFromUserVerification(userVerification);
        return userVerificationDto;
    }

}
