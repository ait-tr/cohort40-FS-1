package group40.secondspringbootrest.dto;

import group40.secondspringbootrest.entity.ToDoEntity;
import lombok.Data;

import java.util.List;

// !!!!!
@Data
public class FindAllToDo {
    private List<ToDoEntity> entities;
    private List<String> errors;

    public FindAllToDo(List<ToDoEntity> entities, List<String> errors) {
        this.entities = entities;
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "FindAllToDo{" +
                "entities=" + entities +
                ", errors=" + errors +
                '}';
    }
}
