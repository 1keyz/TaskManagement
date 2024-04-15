package com.example.taskmanagement.service.impl;

import com.example.taskmanagement.dto.request.AssignTaskToProjectRequest;
import com.example.taskmanagement.dto.request.TaskRequestDto;
import com.example.taskmanagement.dto.request.TaskUpdateRequestDto;
import com.example.taskmanagement.dto.response.TaskDto;
import com.example.taskmanagement.exception.NotFoundException;
import com.example.taskmanagement.model.entity.Project;
import com.example.taskmanagement.model.entity.Task;
import com.example.taskmanagement.repository.TaskRepository;
import com.example.taskmanagement.service.abstracts.ProjectService;
import com.example.taskmanagement.service.abstracts.TaskService;
import com.example.taskmanagement.service.abstracts.UserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final ProjectService projectService;
    private final ModelMapper modelMapper;
    private final UserService userService;

    public TaskServiceImpl(TaskRepository taskRepository, @Lazy ProjectServiceImpl projectService, ModelMapper modelMapper, UserService userService) {
        this.taskRepository = taskRepository;
        this.projectService = projectService;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    public TaskDto addProjectToTask(AssignTaskToProjectRequest request){
        Task task = findByTaskWithId(request.getTaskId());
        task.setAssignedProject(projectService.findByProjectId(request.getProjectId()));
        task.setUpdatedAt(LocalDateTime.now());
        return modelMapper.map(taskRepository.save(task),TaskDto.class);
    }
    public TaskDto create(TaskRequestDto requestDto){
        Task task = Task.builder()
                .name(requestDto.getName())
                .description(requestDto.getDescription())
                .status(requestDto.getStatus())
                .assignedUser(userService.getByUserWithId(requestDto.getUserId()))
                .build();
        task.setCreatedAt(LocalDateTime.now());
        if (requestDto.getProjectId() != 0){
            task.setAssignedProject(projectService.findByProjectId(requestDto.getProjectId()));
        }
        taskRepository.save(task);
        return modelMapper.map(task,TaskDto.class);
    }

    public Task createTask(TaskRequestDto requestDto){
        Task task = Task.builder()
                .name(requestDto.getName())
                .description(requestDto.getDescription())
                .status(requestDto.getStatus())
                .build();
        task.setCreatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }

    @Override
    public TaskDto update(long id ,TaskUpdateRequestDto updateRequestDto) {
        //Task task = findByTaskWithId(id);

        Task task = findByTaskWithId(id);
        task.setUpdatedAt(LocalDateTime.now());
        task.setStatus(updateRequestDto.getStatus());

        taskRepository.save(task);
        return modelMapper.map(task,TaskDto.class);
    }

    @Override
    public void delete(long id) {
        Task task = findByTaskWithId(id);
        task.setDeletedAt(LocalDateTime.now());
        taskRepository.save(task);
        log.info("task silindi");
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public List<TaskDto> getTaskByProjectId(long projectId) {
        Project project = projectService.getByProject(projectId);
        List<TaskDto> taskDtoList =project.getTaskList().stream().map(x -> modelMapper.map(x,TaskDto.class)).collect(Collectors.toList());
        return taskDtoList;
    }

    @Override
    public TaskDto assignUserToTask(long id ,long userId) {
        Task task = taskRepository.getById(id);
        task.setAssignedUser(userService.getByUserWithId(userId));
        return modelMapper.map(task,TaskDto.class);
    }

    protected Task findByTaskWithId(long id){
        return taskRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Task bulunamadı"));
    }
}
