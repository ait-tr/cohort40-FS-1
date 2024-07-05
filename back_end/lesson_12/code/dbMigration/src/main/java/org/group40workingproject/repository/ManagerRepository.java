package org.group40workingproject.repository;


import org.group40workingproject.domain.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {

    Optional<Manager> findByManagerName(String managerName);

//    @Modifying
//    @Query("UPDATE Manager m SET m.managerName = :name WHERE m.id = :id")
//    int updateManagerNameById(@Param("id") Integer id, @Param("name") String name);

}
