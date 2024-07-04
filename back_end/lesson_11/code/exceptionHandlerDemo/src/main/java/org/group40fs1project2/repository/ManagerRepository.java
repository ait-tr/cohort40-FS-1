package org.group40fs1project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.group40fs1project2.entity.Manager;


import java.util.List;
import java.util.Optional;

@Repository
public interface ManagerRepository extends JpaRepository<Manager,Integer> {
    List<Manager> findByManagerName(String managerName);
    Optional<Manager> findByEmail(String email);

}
