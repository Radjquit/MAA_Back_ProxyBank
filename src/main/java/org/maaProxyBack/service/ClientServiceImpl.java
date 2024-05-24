package org.maaProxyBack.service;

import java.util.List;
import java.util.Optional;

import org.maaProxyBack.model.Client2;
import org.maaProxyBack.persistance.ClientPersistance;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientPersistance dao;

    public ClientServiceImpl(ClientPersistance dao) {
        this.dao=dao;
    }

    @Override
    public List<Client2> getAll() {
        return dao.getAll();
    }

    @Override
    public Optional<Client2> getById(long id) {
        return dao.getById(id);
    }

    @Override
    public boolean deleteById(long id) {
        return dao.deleteById(id);
    }

    @Override
    public Client2 update(Client2 client) {
        return dao.update(client);
    }

    @Override
    public Client2 save(Client2 client) {
        System.out.println(client.toString() + "Service");
        return dao.save(client);

    }
}
