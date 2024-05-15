package org.maaProxyBack.persistance;

import org.maaProxyBack.model.Client;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientPersistanceImpl implements ClientPersistance{
    private ClientRepository repository;

    public ClientPersistanceImpl(ClientRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Client> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Client> getById(long id) {
        return repository.findById(id);
    }

    @Override
    public boolean deleteById(long id) {
        boolean toBeReturned = getById(id).isPresent();
        repository.deleteById(id);
        return toBeReturned;
    }

    @Override
    public Client update(Client client) {
        //to be implemented
        return client;
    }

    @Override
    public Client save(Client client) {
        return repository.save(client);
    }
}
