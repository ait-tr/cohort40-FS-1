package org.group40fs1workingproject.dto.taskDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.group40fs1workingproject.dto.managerDto.ManagerResponseDto;
import org.group40fs1workingproject.entity.TaskStatus;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TaskCreateResponseDto {

    private Integer id;
    private String taskName;
    private String taskDescription;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdate;
    private LocalDateTime deadline;
    private TaskStatus status;
    // private String managerName;
    // или предоставить более развернутую информацию
    // о менеджере - но не полную - используем ManagerResponseDto
    private ManagerResponseDto managerResponseDto;

}
