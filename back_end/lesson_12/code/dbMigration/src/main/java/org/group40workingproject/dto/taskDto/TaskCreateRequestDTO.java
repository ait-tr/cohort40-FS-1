package org.group40workingproject.dto.taskDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskCreateRequestDTO {

    private String taskName;
    private String description;
    private LocalDateTime deadline;
    private String managerName;

}
