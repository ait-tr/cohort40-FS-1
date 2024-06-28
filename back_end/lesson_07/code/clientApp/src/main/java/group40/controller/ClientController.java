package group40.controller;

import group40.entity.Client;
import group40.entity.RequestDto;
import group40.service.AddClientService;
import group40.service.DeleteService;
import group40.service.FindService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {

    private final AddClientService addClientService;
    private final FindService findService;
    private final DeleteService deleteService;


    public ResponseEntity<Integer> addNew(RequestDto request){
        return addClientService.addClient(request);
    }


    public ResponseEntity<List<Client>> findAll(){
        return findService.findAll();
    }

    public ResponseEntity<Client> findById(Integer id){
        return findService.findById(id);
    }

    public ResponseEntity<List<Client>> findByName(String name){
        return findService.findByName(name);
    }

    public ResponseEntity<Boolean> deleteClient(Integer id){
        return deleteService.deleteClient(id);
    }

}
