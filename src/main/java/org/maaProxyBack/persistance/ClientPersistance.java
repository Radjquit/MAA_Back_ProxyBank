package org.maaProxyBack.persistance;

import java.util.List;
import java.util.Optional;

import org.maaProxyBack.model.BankClient;

public interface ClientPersistance{
    List<BankClient> getAll();
    Optional<BankClient> getById(long id);
    boolean deleteById(long id);

    List<BankClient> getClientsByAdvisor(long advisorId);

    BankClient update(BankClient client);
    BankClient save(BankClient client);

}
