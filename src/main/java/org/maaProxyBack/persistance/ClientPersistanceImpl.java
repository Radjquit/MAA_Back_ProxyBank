package org.maaProxyBack.persistance;

import java.util.List;
import java.util.Optional;

import org.maaProxyBack.model.BankClient;
import org.springframework.stereotype.Repository;

@Repository
public class ClientPersistanceImpl implements ClientPersistance{
    private ClientRepository repository;

    public ClientPersistanceImpl(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<BankClient> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<BankClient> getById(long id) {
        return repository.findById(id);
    }

    @Override
    public boolean deleteById(long id) {
        boolean toBeReturned = getById(id).isPresent();
        repository.deleteById(id);
        return toBeReturned;
    }

    @Override
    public BankClient update(BankClient client) {
    	return repository.save(client);
    	
    }

    @Override
    public BankClient save(BankClient client) {
        return repository.save(client);
    }

    @Override
    public List<BankClient> getClientsByAdvisor(long advisorId) {
        // return repository.findByAdvisorId(advisorId);
        return repository.findByAdvisor_id(advisorId);
    }


}
