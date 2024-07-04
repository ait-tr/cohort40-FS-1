package org.group40fs1project2.repository;

import org.group40fs1project2.entity.Manager;
import org.group40fs1project2.entity.Task;
import org.group40fs1project2.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {
    List<Task> findByTaskName(String taskName);

    List<Task> findByManager(Manager manager);

    List<Task> findByStatus(TaskStatus status);
}
