package cons4;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {
    private String firstname;
    private String lastname;
    private Integer age;
    private String email;

}
