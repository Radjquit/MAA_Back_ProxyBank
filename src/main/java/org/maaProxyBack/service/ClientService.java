package org.maaProxyBack.service;

import java.util.List;
import java.util.Optional;

import org.maaProxyBack.model.BankClient;

public interface ClientService {
    List<BankClient> getAll();
    Optional<BankClient> getById(long id);
    void deleteById(long id);
    BankClient update(BankClient client);
    BankClient save(BankClient client);
}
