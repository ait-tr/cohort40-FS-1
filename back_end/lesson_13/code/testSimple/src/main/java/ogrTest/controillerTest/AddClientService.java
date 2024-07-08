package ogrTest.controillerTest;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@AllArgsConstructor
public class AddClientService {


    private final ClientRepository clientRepository;

    public Client addClient(@Valid Client client) {

        return clientRepository.save(client);
    }
}
