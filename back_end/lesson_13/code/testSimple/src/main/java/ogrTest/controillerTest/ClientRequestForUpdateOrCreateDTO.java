package ogrTest.controillerTest;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestForUpdateOrCreateDTO {

    @NotBlank(message = "Name is required and cannot be empty.")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters long.")
    private String name;

    @NotBlank(message = "Email is required and cannot be empty.")
    @Email(message = "Email should be valid.")
    private String email;


}
