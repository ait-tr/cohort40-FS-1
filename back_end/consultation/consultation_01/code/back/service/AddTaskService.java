package code.back.service;

import code.back.entity.Task;
import code.back.repository.InMemoryRepository;

public class AddTaskService {

    private final InMemoryRepository repository;

    public AddTaskService(InMemoryRepository repository) {
        this.repository = repository;
    }

    public void addNewTask(){
       // repository.add(new Task());
    }
}
