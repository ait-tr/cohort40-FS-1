package org.group40workingproject.service;

import lombok.RequiredArgsConstructor;
import org.group40workingproject.domain.Manager;
import org.group40workingproject.domain.Role;
import org.group40workingproject.dto.managerDto.ManagerCreateRequestDTO;
import org.group40workingproject.dto.managerDto.ManagerCreateResponseDTO;
import org.group40workingproject.dto.managerDto.ManagerResponseDTO;
import org.group40workingproject.repository.ManagerRepository;
import org.group40workingproject.repository.RoleRepository;
import org.group40workingproject.service.exception.AlreadyExistException;
import org.group40workingproject.service.exception.NotFoundException;
import org.group40workingproject.service.util.ManagerConverter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ManagerService {

    private final ManagerRepository repository;
    private final RoleRepository roleRepository;
    private final ManagerConverter converter;

    public ManagerResponseDTO findByManagerName(String managerName) {
        Manager manager = repository.findByManagerName(managerName)
                .orElseThrow(() -> new NotFoundException("Manager with name " + managerName + " not found"));
        return converter.toDto(manager);
    }

    public Manager findByManagerNameForCreateTask(String managerName) {
        return repository.findByManagerName(managerName)
                .orElseThrow(() -> new NotFoundException("Manager with name " + managerName + " not found"));

    }

    public ManagerCreateResponseDTO createManager(ManagerCreateRequestDTO request){
        if (repository.findByManagerName(request.getManagerName()).isEmpty()) {
            Manager newManager = converter.fromDto(request);
            Optional<Role> defaultRole = roleRepository.findByName("USER");

            if (defaultRole.isPresent()) {
                newManager.setRole(defaultRole.get());
            } else {
                throw new NotFoundException("Role 'USER' not found!");
            }

            Manager savedmanager = repository.save(newManager);
            return converter.toCreateDto(savedmanager);
        } else {
            throw new AlreadyExistException("Manager with name " + request.getManagerName() + " is already exist!");
        }
    }

//    @Transactional
//    public void updateManagerName(Integer id, String name){
//        repository.updateManagerNameById(id,name);
//    }
}
