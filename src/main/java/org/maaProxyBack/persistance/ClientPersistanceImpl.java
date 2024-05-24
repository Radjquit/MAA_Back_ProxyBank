package org.maaProxyBack.persistance;

import java.util.List;
import java.util.Optional;

import org.maaProxyBack.model.Client;
import org.maaProxyBack.model.Client2;
import org.springframework.stereotype.Repository;

@Repository
public class ClientPersistanceImpl implements ClientPersistance{
    private ClientRepository repository;

    public ClientPersistanceImpl(ClientRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Client2> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Client2> getById(long id) {
        return repository.findById(id);
    }

    @Override
    public boolean deleteById(long id) {
        boolean toBeReturned = getById(id).isPresent();
        repository.deleteById(id);
        return toBeReturned;
    }

    @Override
    public Client2 update(Client2 client) {
        //to be implemented
        return client;
    }

    @Override
    public Client2 save(Client2 client) {
        System.out.println(client.toString()+ "Persistance");
        return repository.save(client);
    }
}
