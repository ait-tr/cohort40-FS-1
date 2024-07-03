package org.group40fs1workingproject.controller;

import lombok.AllArgsConstructor;
import org.group40fs1workingproject.dto.taskDto.TaskCreateRequestDto;
import org.group40fs1workingproject.dto.taskDto.TaskCreateResponseDto;
import org.group40fs1workingproject.dto.taskDto.TaskResponseDto;
import org.group40fs1workingproject.entity.Manager;
import org.group40fs1workingproject.entity.Task;
import org.group40fs1workingproject.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService service;

    @PostMapping
    public ResponseEntity<TaskCreateResponseDto> createTask(@RequestBody TaskCreateRequestDto request){
        return new ResponseEntity<>(service.createTask(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDto>> findAllTask(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }


    @GetMapping("/full")
    public ResponseEntity<List<Task>> findAllFull(){
        return new ResponseEntity<>(service.findAllFullTaskDetails(),HttpStatus.OK);
    }
}
