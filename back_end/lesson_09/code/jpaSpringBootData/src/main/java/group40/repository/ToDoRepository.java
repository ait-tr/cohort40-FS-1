package group40.repository;

import group40.entity.ToDoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface ToDoRepository extends JpaRepository<ToDoEntity, Integer> {

    public List<ToDoEntity> findAllByName(String name);

    default Map<String,ToDoEntity> findToDoByWithLongNames(int minLength){
        return findAll().stream()
                .filter(toDoEntity -> toDoEntity.getName() != null && toDoEntity.getName().length() > minLength)
                .collect(Collectors.toMap(ToDoEntity::getName, toDoEntity -> toDoEntity));
    };

    @Query("SELECT t FROM ToDoEntity t WHERE LENGTH(t.name) > 10 AND t.id > :idParam")
    public List<ToDoEntity> findToDoWithNameLengthLongerThanAndIdGreaterThan(@Param("idParam") Integer idParam);

}
