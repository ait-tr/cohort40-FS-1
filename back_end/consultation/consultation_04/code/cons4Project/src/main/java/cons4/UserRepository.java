package cons4;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    public List<User> findByFirstname(String firstName);

    public Optional<User> findByEmail(String email);

}
