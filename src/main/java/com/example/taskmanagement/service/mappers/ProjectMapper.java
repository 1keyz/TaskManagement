package com.example.taskmanagement.service.mappers;

import com.example.taskmanagement.dto.request.ProjectRequestDto;
import com.example.taskmanagement.dto.response.ProjectResponseDto;
import com.example.taskmanagement.model.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectMapper {
    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);
    ProjectResponseDto projectDtoFromProject(Project project);
    Project projectFromProjectRequestDto(ProjectRequestDto requestDto);

}
