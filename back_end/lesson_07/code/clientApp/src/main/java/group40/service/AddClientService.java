package group40.service;

import group40.entity.Client;
import group40.entity.RequestDto;
import group40.repository.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AddClientService {

    private final ClientRepository repository;

    public AddClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<Integer> addClient(RequestDto request){
        Client newClient = new Client(request.getName(),request.getEmail(), request.getPhone());
        Integer idNewClient = repository.add(newClient);
        return new ResponseEntity<>(idNewClient, HttpStatus.CREATED);
    }
}
