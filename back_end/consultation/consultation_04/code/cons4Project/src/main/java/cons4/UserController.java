package cons4;

import lombok.AllArgsConstructor;
import org.mapstruct.control.MappingControl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public User addUser(@RequestBody UserDTO userDTO){
        return service.addUser(userDTO);
    }

    @GetMapping
    public List<User> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Integer id){
        return service.findById(id);
    }

    // localhost:8080/api/users/findByName?firstName=James

    @GetMapping("/findByName")
    public List<User> findByName(@RequestParam(value = "firstName") String firstName){
        return service.findByFirstName(firstName);
    }

    // localhost:8080/api/users/findByEmail?email=email1@email.com

    @GetMapping("/findByEmail")
    public User findByEmail(@RequestParam(value = "email") String email){
        return service.findByEmail(email);
    }

    @PutMapping
    public User update(@RequestBody User user){
        return service.update(user);
    }

}
