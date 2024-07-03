package group40.democonsultation3.repository;

import group40.democonsultation3.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ArrayListRepository implements InMemoryRepository{

    private List<Order> database;
    private Integer orderCounter = 0;

    public ArrayListRepository(List<Order> database) {
        this.database = database;
    }

    @Override
    public Order add(Order order) {
        order.setId(++orderCounter);
        database.add(order);
        return order;
    }

    @Override
    public List<Order> findAll() {
        return database;
    }

    @Override
    public Optional<Order> findById(Integer id) {
        return database.stream()
                .filter(order -> order.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Order> findByName(String name) {
        return database.stream()
                .filter(order -> order.getName().equals(name))
                .toList();
    }
}
