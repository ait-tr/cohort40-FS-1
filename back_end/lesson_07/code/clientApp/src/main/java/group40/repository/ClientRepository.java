package group40.repository;

import group40.entity.Client;

import java.lang.ref.Cleaner;
import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    Integer add(Client client);

    List<Client> findAll();

    Optional<Client> findById(Integer id);

    List<Client> findByName(String name);

    Optional<Client> findByEmail(String email);

    boolean update(Client clientForUpdate);

    boolean delete(Integer id);

}
