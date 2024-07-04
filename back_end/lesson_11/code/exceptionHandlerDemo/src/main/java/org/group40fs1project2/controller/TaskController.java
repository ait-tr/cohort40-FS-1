package org.group40fs1project2.controller;


import lombok.AllArgsConstructor;
import org.group40fs1project2.dto.taskDto.TaskCreateRequestDto;
import org.group40fs1project2.dto.taskDto.TaskCreateResponseDto;
import org.group40fs1project2.dto.taskDto.TaskResponseDto;
import org.group40fs1project2.entity.Task;
import org.group40fs1project2.exception.NotFoundException;
import org.group40fs1project2.service.TaskService;
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

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDto> findTaskById(@PathVariable Integer id){

        TaskResponseDto response = service.findById(id);
        return new ResponseEntity<>(response,HttpStatus.OK);

//        try{
//            TaskResponseDto response = service.findById(id);
//            return new ResponseEntity<>(response,HttpStatus.OK);
//        } catch (NotFoundException e){
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        }

    }


    @GetMapping("/full")
    public ResponseEntity<List<Task>> findAllFull(){
        return new ResponseEntity<>(service.findAllFullTaskDetails(),HttpStatus.OK);
    }
}
