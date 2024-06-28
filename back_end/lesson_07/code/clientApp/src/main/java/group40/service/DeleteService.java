package group40.service;

import group40.repository.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class DeleteService {
    private final ClientRepository repository;

    public DeleteService(ClientRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<Boolean> deleteClient(Integer id){
        boolean deleteResult = repository.delete(id);

        if (deleteResult) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }
}
