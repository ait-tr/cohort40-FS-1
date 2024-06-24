package code.back.service;

import code.back.dto.RequestDto;
import code.back.dto.ResponseDto;
import code.back.entity.Task;
import code.back.repository.InMemoryRepository;
import code.back.service.validation.validationRules.CodeError;

import java.util.List;

public class AddTaskService {

    private final InMemoryRepository repository;
    private final ValidationService validationService;

    public AddTaskService(InMemoryRepository repository, ValidationService validationService) {
        this.repository = repository;
        this.validationService = validationService;
    }

    public ResponseDto<Task> addNewTask(RequestDto request) {
        System.out.println("Received request: " + request);
        // валидация данных
        List<CodeError> errors = validationService.validation(request);
        Task savedTask = new Task();

        if (errors.isEmpty()) {
            Task taskForSave = new Task(0, request.getName(), request.getDescription());
            savedTask = repository.add(taskForSave);
        }

        return new ResponseDto<>(savedTask, errors);
    }
}
