package org.group40fs1project2.controller;

import lombok.AllArgsConstructor;
import org.group40fs1project2.entity.Manager;
import org.group40fs1project2.dto.managerDto.ManagerCreateRequestDto;
import org.group40fs1project2.dto.managerDto.ManagerCreateResponseDto;
import org.group40fs1project2.dto.managerDto.ManagerResponseDto;
import org.group40fs1project2.service.ManagerService;
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
