package org.group40fs1project2.service;

import lombok.AllArgsConstructor;
import org.group40fs1project2.dto.taskDto.TaskCreateRequestDto;
import org.group40fs1project2.dto.taskDto.TaskCreateResponseDto;
import org.group40fs1project2.dto.taskDto.TaskResponseDto;
import org.group40fs1project2.entity.Manager;
import org.group40fs1project2.entity.Task;
import org.group40fs1project2.entity.TaskStatus;
import org.group40fs1project2.exception.NotFoundException;
import org.group40fs1project2.repository.TaskRepository;
import org.group40fs1project2.service.util.TaskConverter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final ManagerService managerService;
    private final TaskConverter converter;

    public List<TaskResponseDto> findAll(){
//        List<Task> tasks = taskRepository.findAll();
//        List<TaskResponseDto> dtos = new ArrayList<>();
//        for (Task task : tasks) {
//            TaskResponseDto dto = converter.toDto(task);
//            dtos.add(dto);
//        }
//
//        return dtos;

        return taskRepository.findAll().stream()
                .map(converter::toDto)
                .toList();
    }

    public TaskResponseDto findById(Integer id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Task with id = " + id + " not found"));
        return converter.toDto(task);
    }

    // получить список задач по почте менеджера

    public List<TaskResponseDto> findTasksByManagerEmail(String managerEmail) {

        Manager responseDto = managerService.findManagerByEmail(managerEmail);

        return taskRepository.findByManager(responseDto).stream()
                .map(converter::toDto)
                .toList();

    }

    public TaskCreateResponseDto createTask(TaskCreateRequestDto request) {

        Manager manager = managerService.findByManagerEmailForCreateTask(request.getManagerEmail());
        Task newTask = converter.fromCreateRequest(request);
        newTask.setManager(manager);
        newTask.setCreateDate(LocalDateTime.now());
        newTask.setLastUpdate(LocalDateTime.now());
        newTask.setStatus(TaskStatus.OPEN);
        return converter.toCreateDto(taskRepository.save(newTask));

    }

    public List<Task> findAllFullTaskDetails(){
        return taskRepository.findAll();
    }

}
