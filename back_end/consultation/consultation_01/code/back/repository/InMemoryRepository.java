package code.back.repository;

import code.back.entity.Task;

import java.util.List;
import java.util.Optional;

public interface InMemoryRepository {

    Task add(Task task);

    Optional<Task> findById(Integer id);

    List<Task> findByName(String taskName);

    boolean deleteById(Integer id);

    Optional<Task> updateTask(Integer id, String newDescription);

    List<Task> findAll();


}
