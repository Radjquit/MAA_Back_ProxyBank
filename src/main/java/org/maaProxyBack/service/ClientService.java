package org.maaProxyBack.service;

import java.util.List;
import java.util.Optional;

import org.maaProxyBack.model.Client2;

public interface ClientService {
    List<Client2> getAll();
    Optional<Client2> getById(long id);
    boolean deleteById(long id);
    Client2 update(Client2 client);
    Client2 save(Client2 client);
}
