package org.group40fs1project2.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    @Lob - Large Object - аннотация говорит что в таблице базы данных мы хотим видеть поле типа TEXT а не VARCHAR

    @NotBlank(message = "Manager name must be not blank")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "manager name can contain only latin character and digital")
    private String managerName;

    @NotBlank(message = "Manager password must be not blank")
    private String password;

    @NotBlank(message = "Email must be not blank")
    @Email(message = "Invalid email format")
    private String email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
    //@JsonIgnore
    @ToString.Exclude
    @JsonManagedReference
    private List<Task> tasks;
}
