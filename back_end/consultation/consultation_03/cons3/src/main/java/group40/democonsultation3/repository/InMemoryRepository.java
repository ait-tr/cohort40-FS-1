package group40.democonsultation3.repository;

import group40.democonsultation3.entity.Order;

import java.util.List;
import java.util.Optional;

public interface InMemoryRepository {

    Order add(Order order);
    List<Order>  findAll();
    Optional<Order> findById(Integer id);
    List<Order> findByName(String name);

}
