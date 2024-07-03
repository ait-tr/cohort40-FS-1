package org.group40fs1workingproject.dto.managerDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagerCreateRequestDto {
    private String managerName;
    private String password;
    private String email;
}
