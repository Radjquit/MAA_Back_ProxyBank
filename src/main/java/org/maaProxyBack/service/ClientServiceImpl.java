package org.maaProxyBack.service;

import org.maaProxyBack.model.Client;
import org.maaProxyBack.persistance.ClientPersistance;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientPersistance dao;

    public ClientServiceImpl(ClientPersistance dao) {
        this.dao=dao;
    }

    @Override
    public List<Client> getAll() {
        return dao.getAll();
    }

    @Override
    public Optional<Client> getById(long id) {
        return dao.getById(id);
    }

    @Override
    public boolean deleteById(long id) {
        return dao.deleteById(id);
    }

    @Override
    public Client update(Client client) {
        return dao.update(client);
    }

    @Override
    public Client save(Client client) {
        return dao.save(client);
    }
}
