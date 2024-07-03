package group40.democonsultation3.controller;

import group40.democonsultation3.entity.Order;
import group40.democonsultation3.service.OrderServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class FindOrderController {
    private final OrderServiceInterface service;

    public FindOrderController(OrderServiceInterface service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable Integer id){
        return service.findById(id);
    }

    @GetMapping("/byName")
    // полный путь localhost:8080/orders/find/byName?orderName=order1
    public ResponseEntity<List<Order>> findByOrderName(@RequestParam(value = "orderName") String name){
        return service.findByName(name);
    }

}
