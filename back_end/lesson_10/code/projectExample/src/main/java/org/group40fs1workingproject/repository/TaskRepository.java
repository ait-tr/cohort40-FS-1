package org.group40fs1workingproject.repository;

import org.group40fs1workingproject.entity.Manager;
import org.group40fs1workingproject.entity.Task;
import org.group40fs1workingproject.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {
    List<Task> findByTaskName(String taskName);

    List<Task> findByManager(Manager manager);

    List<Task> findByStatus(TaskStatus status);
}
