package group40.democonsultation3.service;

import group40.democonsultation3.dto.ClientRequestDTO;
import group40.democonsultation3.entity.Order;
import group40.democonsultation3.repository.InMemoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements OrderServiceInterface{

    private final InMemoryRepository repository;

    public OrderService(InMemoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity<Order> add(ClientRequestDTO request) {
        Order newOrder = new Order(0, request.getName(), request.getStatus());
        Order savedOrder = repository.add(newOrder);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Order>> findAll() {
        List<Order> orders = repository.findAll();

        if (orders.isEmpty()) {
            return new ResponseEntity<>(orders,HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(orders,HttpStatus.OK);
        }

    }

    @Override
    public ResponseEntity<Order> findById(Integer id) {
        Optional<Order> orderOptional = repository.findById(id);
        if (orderOptional.isPresent()) {
            return new ResponseEntity<>(orderOptional.get(), HttpStatus.OK);
            // аналогично
            // return new ResponseEntity.ok(orderOptional.get());
        } else {
            return new ResponseEntity<>(new Order(),HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity<List<Order>> findByName(String name) {
        List<Order> ordersByName = repository.findByName(name);
        if (ordersByName.isEmpty()) {
            return new ResponseEntity<>(ordersByName, HttpStatus.NO_CONTENT);
             } else {
            return new ResponseEntity<>(ordersByName,HttpStatus.OK);
        }
    }
}
