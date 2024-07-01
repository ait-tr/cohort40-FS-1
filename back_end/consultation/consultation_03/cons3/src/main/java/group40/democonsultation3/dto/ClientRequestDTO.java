package group40.democonsultation3.dto;

import group40.democonsultation3.entity.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDTO {
    private String name;
    private OrderStatus status;
}
