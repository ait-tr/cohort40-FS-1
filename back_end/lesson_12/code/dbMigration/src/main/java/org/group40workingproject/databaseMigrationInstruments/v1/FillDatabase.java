package org.group40workingproject.databaseMigrationInstruments.v1;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.group40workingproject.domain.Role;
import org.group40workingproject.repository.RoleRepository;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
//@Component
public class FillDatabase {

    private final RoleRepository roleRepository;

    public void fillRoleTable(){
        Role admin = new Role("ADMIN");
        roleRepository.save(admin);

        Role user = new Role("USER");
        roleRepository.save(user);

    }
}
