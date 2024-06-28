package group40.service;

import group40.entity.Client;
import group40.repository.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class FindService {

    private final ClientRepository repository;

    public FindService(ClientRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<List<Client>> findAll(){
        List<Client> allClients = repository.findAll();

        if (!allClients.isEmpty()) {
        return new ResponseEntity<>(allClients, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(allClients,HttpStatus.NOT_ACCEPTABLE);
        }
    }

    public ResponseEntity<Client> findById(Integer id){
        Optional<Client> foundClientOpt = repository.findById(id);

        if (foundClientOpt.isPresent()) {
            return new ResponseEntity<>(foundClientOpt.get(),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<Client>> findByName(String name){
        List<Client> foundClients = repository.findByName(name);

        if (!foundClients.isEmpty()) {
            return new ResponseEntity<>(foundClients,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(foundClients, HttpStatus.NOT_ACCEPTABLE);
        }

    }

}
