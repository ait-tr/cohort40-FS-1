package group40.secondspringbootrest.service;

import group40.secondspringbootrest.dto.AddToDoRequest;
import group40.secondspringbootrest.entity.ToDoEntity;
import group40.secondspringbootrest.repository.ToDoRepository;
import org.springframework.stereotype.Service;

@Service
public class AddToDoService {

    private ToDoRepository repository;

    public AddToDoService(ToDoRepository repository) {
        this.repository = repository;
    }

    public ToDoEntity add(AddToDoRequest request){
        System.out.println("Received request: " + request);
        var entityForAdd = convert(request);
        var createdEntity = repository.save(entityForAdd);
        System.out.println("Sending response: " + createdEntity);
        return createdEntity;
    }

    private ToDoEntity convert(AddToDoRequest request){
        ToDoEntity newEntity = new ToDoEntity();
        newEntity.setName(request.getName());
        newEntity.setDescription(request.getDescription());
        return newEntity;
    }

}
