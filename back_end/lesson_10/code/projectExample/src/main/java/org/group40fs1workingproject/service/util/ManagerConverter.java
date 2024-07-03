package org.group40fs1workingproject.service.util;

import org.group40fs1workingproject.dto.managerDto.ManagerCreateRequestDto;
import org.group40fs1workingproject.dto.managerDto.ManagerCreateResponseDto;
import org.group40fs1workingproject.dto.managerDto.ManagerResponseDto;
import org.group40fs1workingproject.entity.Manager;
import org.springframework.stereotype.Service;

@Service
public class ManagerConverter {

    public Manager fromDto(ManagerCreateRequestDto dto){
        Manager manager = new Manager();

        if (dto.getManagerName() != null) {
            manager.setManagerName(dto.getManagerName());
        }

        if (dto.getPassword() != null) {
            manager.setPassword(dto.getPassword());
        }

        if (dto.getEmail() != null) {
            manager.setEmail(dto.getEmail());
        }

        return manager;
    }


    public ManagerCreateResponseDto toCreateDto(Manager manager){
        String role = manager.getRole().getName();
        return new ManagerCreateResponseDto(
                manager.getId(),
                manager.getManagerName(),
                role
        );
    }

    public ManagerResponseDto toDto(Manager manager){
        String role = manager.getRole().getName();
        return new ManagerResponseDto(
                manager.getId(),
                manager.getManagerName(),
                manager.getEmail(),
                role
        );
    }

}
