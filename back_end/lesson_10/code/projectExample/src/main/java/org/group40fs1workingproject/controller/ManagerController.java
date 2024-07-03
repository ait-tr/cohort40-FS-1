package org.group40fs1workingproject.controller;

import lombok.AllArgsConstructor;
import org.group40fs1workingproject.dto.managerDto.ManagerCreateRequestDto;
import org.group40fs1workingproject.dto.managerDto.ManagerCreateResponseDto;
import org.group40fs1workingproject.dto.managerDto.ManagerResponseDto;
import org.group40fs1workingproject.entity.Manager;
import org.group40fs1workingproject.service.ManagerService;
import org.group40fs1workingproject.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/managers")
public class ManagerController {

    private final ManagerService service;

    @PostMapping
    public ResponseEntity<ManagerCreateResponseDto> createNewManager(@RequestBody ManagerCreateRequestDto request){
        return new ResponseEntity(service.createManager(request), HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<ManagerResponseDto>> findAll(){
        return new ResponseEntity<>(service.findAll(),HttpStatus.OK);
    }

    @GetMapping("/full")
    public ResponseEntity<List<Manager>> findAllFull(){
        return new ResponseEntity<>(service.findAllFullManagerDetails(),HttpStatus.OK);
    }



}
