package org.group40fs1workingproject.repository;

import org.group40fs1workingproject.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ManagerRepository extends JpaRepository<Manager,Integer> {
    List<Manager> findByManagerName(String managerName);
    Optional<Manager> findByEmail(String email);

}
