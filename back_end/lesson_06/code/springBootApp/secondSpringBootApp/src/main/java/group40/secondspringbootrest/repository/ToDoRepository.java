package lesson_06.code.springBootApp.secondSpringBootApp.src.main.java.group40.secondspringbootrest.repository;

import group40.secondspringbootrest.entity.ToDoEntity;

import java.util.List;
import java.util.Optional;

public interface ToDoRepository {

    ToDoEntity save(ToDoEntity entity);

    List<ToDoEntity> findAll();

    Optional<ToDoEntity> findById(Integer id);

}
