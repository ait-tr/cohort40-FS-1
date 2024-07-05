package org.group40workingproject.dto.taskDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.group40workingproject.domain.TaskStatus;
import org.group40workingproject.dto.managerDto.ManagerCreateResponseDTO;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskCreateOrUpdateResponseDTO {

    private Integer id;
    private String taskName;
    private String description;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdate;
    private LocalDateTime deadline;
    private TaskStatus status;
    private ManagerCreateResponseDTO managerCreateResponseDTO;

}
