package group40.controller;

import group40.entity.Client;
import group40.entity.RequestDto;
import group40.service.AddClientService;
import group40.service.DeleteService;
import group40.service.FindService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {

    private final AddClientService addClientService;
    private final FindService findService;
    private final DeleteService deleteService;

    @PostMapping("/addNew")
    public ResponseEntity<Integer> addNew(@RequestBody RequestDto request){
        return addClientService.addClient(request);
    }

    @GetMapping
    public ResponseEntity<List<Client>> findAll(){
        return findService.findAll();
    }


    @GetMapping("/{id}") // полный путь будет выглядеть /clients/12
    public ResponseEntity<Client> findById(@PathVariable Integer id){
        return findService.findById(id);
    }

    @GetMapping("/findByName")
    // localhost:8080/clients/findByName?nameClient=John
    public ResponseEntity<List<Client>> findByName(@RequestParam(value = "nameClient") String name){
        return findService.findByName(name);
    }

    @DeleteMapping("/{id}") // если имя переменной совпадает с названием внутри {} то name можно не указывать
    public ResponseEntity<Boolean> deleteClient(@PathVariable(name = "id") Integer id){
        return deleteService.deleteClient(id);
    }

}
