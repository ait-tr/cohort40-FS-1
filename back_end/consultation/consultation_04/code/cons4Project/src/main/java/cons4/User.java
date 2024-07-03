package cons4;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstname;
    private String lastname;
    private Integer age;
    private String email;

    public User(UserDTO userDTO) {
        this.firstname = userDTO.getFirstname();
        this.lastname = userDTO.getLastname();
        this.age = userDTO.getAge();
        this.email = userDTO.getEmail();
    }
}
