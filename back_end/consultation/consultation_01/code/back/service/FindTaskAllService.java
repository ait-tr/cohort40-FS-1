package code.back.service;

import code.back.dto.ResponseDto;
import code.back.entity.Task;
import code.back.repository.InMemoryRepository;
import code.back.service.validation.validationRules.CodeError;

import java.util.ArrayList;
import java.util.List;

public class FindTaskAllService {

    private InMemoryRepository repository;

    public FindTaskAllService(InMemoryRepository repository) {
        this.repository = repository;
    }

    public ResponseDto<List<Task>> findAll(){

        List<CodeError> errors = new ArrayList<>();
        List<Task> allTasks = repository.findAll();

        if (allTasks.isEmpty()){
            errors.add(new CodeError("Task database is empty"));
        }
        return new ResponseDto<>(allTasks,errors);

    }
}
