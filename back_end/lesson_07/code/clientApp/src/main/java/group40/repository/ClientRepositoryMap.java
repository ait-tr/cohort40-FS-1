package group40.repository;

import group40.entity.Client;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class ClientRepositoryMap implements ClientRepository{

    private Integer clientId = 0;

    private Map<Integer,Client> database = new HashMap<>();


    @Override
    public Integer add(Client client) {
        client.setId(++clientId);
        database.put(clientId,client);
        return clientId;
    }

    @Override
    public List<Client> findAll() {
        return new ArrayList<>(database.values());
    }

    @Override
    public Optional<Client> findById(Integer id) {
        return Optional.ofNullable(database.get(id));
    }

    @Override
    public List<Client> findByName(String name) {
        return database.values().stream()
                .filter(client -> client.getName().equals(name))
                .toList();
    }

    @Override
    public Optional<Client> findByEmail(String email) {
        return database.values().stream()
                .filter(client -> client.getEmail().equals(email))
                .findFirst();
    }

    @Override
    public boolean update(Client clientForUpdate) {
        if (database.get(clientForUpdate.getId()) != null){
            database.put(clientForUpdate.getId(),clientForUpdate);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
//        Client removeResult = database.remove(id);
//        if (removeResult != null){
//            return true;
//        }
//        return false;

        return database.remove(id) != null;
    }
}
