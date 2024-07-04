package org.group40fs1project2.service.util;


import org.group40fs1project2.dto.managerDto.ManagerResponseDto;
import org.group40fs1project2.dto.taskDto.TaskCreateRequestDto;
import org.group40fs1project2.dto.taskDto.TaskCreateResponseDto;
import org.group40fs1project2.dto.taskDto.TaskResponseDto;
import org.group40fs1project2.entity.Role;
import org.group40fs1project2.entity.Task;
import org.springframework.stereotype.Service;

@Service
public class TaskConverter {

    public TaskCreateResponseDto toCreateDto(Task task) {
        TaskCreateResponseDto dto = new TaskCreateResponseDto();
        dto.setId(task.getId());
        dto.setTaskName(task.getTaskName());
        dto.setTaskDescription(task.getTaskDescription());
        dto.setCreateDate(task.getCreateDate());
        dto.setLastUpdate(task.getLastUpdate());
        dto.setDeadline(task.getDeadline());
        dto.setStatus(task.getStatus());

        Role managerRole = task.getManager().getRole();

        dto.setManagerResponseDto(new ManagerResponseDto(
                task.getManager().getId(),
                task.getManager().getManagerName(),
                task.getManager().getEmail(),
                managerRole.getName()));

        return dto;
    }

    public TaskResponseDto toDto(Task task) {
        TaskResponseDto dto = new TaskResponseDto();
        dto.setId(task.getId());
        dto.setTaskName(task.getTaskName());
        dto.setTaskDescription(task.getTaskDescription());
        dto.setCreateDate(task.getCreateDate());
        dto.setLastUpdate(task.getLastUpdate());
        dto.setDeadline(task.getDeadline());
        dto.setStatus(task.getStatus());

        return dto;
    }

    public Task fromCreateRequest(TaskCreateRequestDto dto) {
        Task task = new Task();
        if (dto.getTaskName() != null) {
            task.setTaskName(dto.getTaskName());
        }
        if (dto.getTaskDescription() != null) {
            task.setTaskDescription(dto.getTaskDescription());
        }
        if (dto.getDeadline() != null) {
            task.setDeadline(dto.getDeadline());
        }

        return task;
    }

}
