package org.group40fs1workingproject.dto.taskDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskCreateRequestDto {

    private String taskName;
    private String taskDescription;
    private LocalDateTime deadline;
    private String managerEmail;

}
