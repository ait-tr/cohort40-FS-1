package group40.democonsultation3.controller;

import group40.democonsultation3.dto.ClientRequestDTO;
import group40.democonsultation3.entity.Order;
import group40.democonsultation3.service.OrderServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class AddOrderController {
    private final OrderServiceInterface service;

    public AddOrderController(OrderServiceInterface service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<Order> addOrder(@RequestBody ClientRequestDTO request){
        return service.add(request);
    }

}
