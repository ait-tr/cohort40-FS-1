package group40.secondspringbootrest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDoEntity {
    private Integer id;
    private String name;
    private String description;


}
