package group40.secondspringbootrest;

import group40.secondspringbootrest.dto.AddToDoRequest;
import group40.secondspringbootrest.repository.ArrayToDoRepository;
import group40.secondspringbootrest.repository.ToDoRepository;
import group40.secondspringbootrest.service.AddToDoService;
import group40.secondspringbootrest.service.FindAllToDoService;
import group40.secondspringbootrest.service.FindToDoByIdService;

public class App {
    public static void main(String[] args) {
        ToDoRepository repository = new ArrayToDoRepository();
        AddToDoService addToDoService = new AddToDoService(repository);
        FindAllToDoService findAllToDoService = new FindAllToDoService(repository);
        FindToDoByIdService findToDoByIdService = new FindToDoByIdService(repository);


        System.out.println(findAllToDoService.findAll());

        AddToDoRequest request1 = new AddToDoRequest("name1", "description1");
        addToDoService.add(request1);


        System.out.println(findAllToDoService.findAll());

        System.out.println(findToDoByIdService.findById(2));
    }
}
