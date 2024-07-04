package org.group40fs1project2.service;

import org.group40fs1project2.dto.managerDto.ManagerCreateRequestDto;
import org.group40fs1project2.dto.managerDto.ManagerCreateResponseDto;
import org.group40fs1project2.dto.managerDto.ManagerResponseDto;
import org.group40fs1project2.entity.Manager;
import org.group40fs1project2.entity.Role;
import org.group40fs1project2.exception.AlreadyExistException;
import org.group40fs1project2.repository.ManagerRepository;
import org.group40fs1project2.repository.RoleRepository;
import org.group40fs1project2.service.util.ManagerConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {

    private final ManagerRepository repository;
    private final RoleRepository roleRepository;
    private final ManagerConverter converter;

    public ManagerService(ManagerRepository repository, RoleRepository roleRepository, ManagerConverter converter) {
        this.repository = repository;
        this.roleRepository = roleRepository;
        this.converter = converter;
    }

    public ManagerCreateResponseDto createManager(ManagerCreateRequestDto request) {
        if (repository.findByEmail(request.getEmail()).isEmpty()) {
            Manager newManager = converter.fromDto(request);

            // Role newManagerRole = new Role(1,"USER"); - не работает для связи данных между таблицами

            Optional<Role> defaultRole = roleRepository.findByName("USER");

            if (defaultRole.isPresent()) {
                newManager.setRole(defaultRole.get());
            } else {
                throw new RuntimeException("Role 'USER' not found");
            }

            Manager savedManager = repository.save(newManager);

            return converter.toCreateDto(savedManager);
        } else {
            throw new AlreadyExistException("Manager with email " + request.getEmail() + " is already exist");
        }
    }

    public Manager findManagerByEmail(String email) {
        Optional<Manager> managerOptional = repository.findByEmail(email);

        Manager manager = new Manager();

        if (managerOptional.isPresent()) {
            manager = managerOptional.get();
        }

        return manager;
    }


    public Manager findByManagerEmailForCreateTask(String managerEmail) {
        return repository.findByEmail(managerEmail)
                .orElseThrow();

    }

    public List<ManagerResponseDto> findAll(){
        return repository.findAll().stream()
                .map(manager -> converter.toDto(manager))
                .toList();
    }

    public List<Manager> findAllFullManagerDetails(){
        return repository.findAll();
    }

}
