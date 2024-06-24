package code.back.service;

import code.back.dto.ResponseDto;
import code.back.entity.Task;
import code.back.repository.InMemoryRepository;
import code.back.service.validation.validationRules.CodeError;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

public class FindTaskByIdService {

    private InMemoryRepository repository;

    public FindTaskByIdService(InMemoryRepository repository) {
        this.repository = repository;
    }

    public ResponseDto<Task> findById(Integer id){
        Optional<Task> foundedTaskOpt = repository.findById(id);
        Task foundedTask = new Task();

        List<CodeError> errors = new ArrayList<>();

        if (foundedTaskOpt.isEmpty()){
            errors.add(new CodeError("Task with id = " + id + " not found"));
        } else {
            foundedTask = foundedTaskOpt.get();
        }

        return new ResponseDto<>(foundedTask,errors);
    }
}
