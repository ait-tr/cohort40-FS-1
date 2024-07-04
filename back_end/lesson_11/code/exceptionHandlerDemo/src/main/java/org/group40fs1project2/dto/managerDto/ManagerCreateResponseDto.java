package org.group40fs1project2.dto.managerDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagerCreateResponseDto {
    private Integer id;
    private String managerName;
    private String role;
}
