package ogrTest.controillerTest;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {

    private final AddClientService addClientService;

    @PostMapping("/addNewClient")
    public ResponseEntity<Client> addNewClient(@RequestBody @Valid ClientRequestForUpdateOrCreateDTO clientDto) {
        Client client = new Client();
        client.setName(clientDto.getName());
        client.setEmail(clientDto.getEmail());
        client = addClientService.addClient(client);
        return ResponseEntity.ok(client);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, Object> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(Map.of("errors", errors));
    }

}
