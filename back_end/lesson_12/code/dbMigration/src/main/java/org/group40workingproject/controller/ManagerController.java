package org.group40workingproject.controller;

import lombok.AllArgsConstructor;
import org.group40workingproject.dto.managerDto.ManagerCreateRequestDTO;
import org.group40workingproject.dto.managerDto.ManagerCreateResponseDTO;
import org.group40workingproject.service.ManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/managers")
public class ManagerController {

    private final ManagerService managerService;

    @PostMapping
    public ResponseEntity<ManagerCreateResponseDTO> createManager(@RequestBody ManagerCreateRequestDTO request) {
        return new ResponseEntity<>(managerService.createManager(request), HttpStatus.CREATED);
    }
}
