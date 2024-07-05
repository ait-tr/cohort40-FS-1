package org.group40workingproject.dto.managerDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.group40workingproject.domain.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagerResponseDTO {

    private Integer id;
    private String managerName;
    private String email;
    private Role role;
}
