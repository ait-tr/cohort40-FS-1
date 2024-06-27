package lesson_06.code.springBootApp.secondSpringBootApp.src.main.java.group40.secondspringbootrest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddToDoRequest {
    private String name;
    private String description;

}
