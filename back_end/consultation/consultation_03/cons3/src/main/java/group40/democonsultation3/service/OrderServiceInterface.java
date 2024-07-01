package group40.democonsultation3.service;

import group40.democonsultation3.dto.ClientRequestDTO;
import group40.democonsultation3.entity.Order;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderServiceInterface {

    ResponseEntity<Order> add(ClientRequestDTO request);
    ResponseEntity<List<Order>> findAll();
    ResponseEntity<Order> findById(Integer id);
    ResponseEntity<List<Order>> findByName(String name);

}
