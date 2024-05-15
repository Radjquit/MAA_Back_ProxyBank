package org.maaProxyBack.persistance;

import org.maaProxyBack.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientPersistance{
    List<Client> getAll();
    Optional<Client> getById(long id);
    boolean deleteById(long id);
    Client update(Client client);
    Client save(Client client);

}
