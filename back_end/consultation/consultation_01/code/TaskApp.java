package code;

import code.back.repository.InMemoryRepository;
import code.back.repository.TaskRepository;
import code.back.service.AddTaskService;
import code.back.service.FindTaskByIdService;
import code.back.service.ValidationService;
import code.back.service.FindTaskAllService;
import code.back.service.validation.validationRules.*;

import java.util.ArrayList;
import java.util.List;

public class TaskApp {
    public static void main(String[] args) {

        List<ValidationRule> validationRules = new ArrayList<>();
        validationRules.add(new TaskNameNullValidation());
        validationRules.add(new TaskDescriptionNullValidation());
        validationRules.add(new TaskNameMinxLengthValidation());
        validationRules.add(new TaskNameMaxLengthValidation());

        InMemoryRepository repository = new TaskRepository();

        ValidationService validationService = new ValidationService(validationRules);

        AddTaskService addTaskService = new AddTaskService(repository, validationService);
        FindTaskByIdService findTaskByIdService = new FindTaskByIdService(repository);
        FindTaskAllService findTaskAllService = new FindTaskAllService(repository);

        //......

        // user interface создать куда передать ссылки на соответсвующее сервисы




    }
}
