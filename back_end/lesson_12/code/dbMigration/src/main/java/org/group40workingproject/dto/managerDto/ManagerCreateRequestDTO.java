package org.group40workingproject.dto.managerDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagerCreateRequestDTO {

    private String managerName;
    private String password;
    private String email;
}
