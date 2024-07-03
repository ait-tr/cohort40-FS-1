package cons4;


import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User addUser(UserDTO userDTO){
        User newUser = new User(userDTO);
        return repository.save(newUser);
    }

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Integer id){
        Optional<User> userOpt = repository.findById(id);
        if (userOpt.isPresent()) {
            return userOpt.get();
        } else {
            throw new RuntimeException("Not found!");
        }
    }

    public List<User> findByFirstName(String firstName){
        return repository.findByFirstname(firstName);
    }

    public User findByEmail(String email){
        Optional<User> userOpt = repository.findByEmail(email);
        if (userOpt.isPresent()) {
            return userOpt.get();
        } else {
            throw new RuntimeException("Not found!");
        }
    }

    public User update(User updateuser){
        return repository.save(updateuser);
    }

}
