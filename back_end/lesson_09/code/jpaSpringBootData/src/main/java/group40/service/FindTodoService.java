package group40.service;

import group40.entity.ToDoEntity;
import group40.repository.ToDoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class FindTodoService {

    private final ToDoRepository repository;

    public FindTodoService(ToDoRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<List<ToDoEntity>> findAll(){
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    public List<ToDoEntity> getToDoWithNameLengthLongerThanAndIdGreaterThan(Integer idParam){
        return repository.findToDoWithNameLengthLongerThanAndIdGreaterThan(idParam);
    }

}
