package code.service;

import code.dto.RequestDto;
import code.dto.ResponseDto;
import code.entity.Task;
import code.repository.TaskRepository;
import code.service.validation.Validation;

import java.util.List;

public class TaskServiceAdd {

    private final TaskRepository repository;
    private final Validation validation;

    public TaskServiceAdd(TaskRepository repository, Validation validation) {
        this.repository = repository;
        this.validation = validation;
    }

    public ResponseDto<Task> addNewTask(RequestDto requestDto){
        System.out.println("Received request: " + requestDto);

        // проводим валидацию данных

        List<String> errors =  validation.validate(requestDto);

        if (errors.isEmpty()) {
            Task taskForAdd = new Task(0, requestDto.getName(), requestDto.getDescription());
            Task savedTask = repository.add(taskForAdd);
            return new ResponseDto<>(200,savedTask,errors);
        } else {
            return new ResponseDto<>(400,new Task(),errors);
        }

    }
}
