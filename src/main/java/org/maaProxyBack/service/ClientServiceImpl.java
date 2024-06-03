package org.maaProxyBack.service;

import java.util.List;
import java.util.Optional;

import org.maaProxyBack.model.BankClient;
import org.maaProxyBack.persistance.ClientPersistance;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientPersistance dao;

    public ClientServiceImpl(ClientPersistance dao) {
        this.dao=dao;
    }
    

    public ClientServiceImpl() {
		super();
	}


	@Override
    public List<BankClient> getAll() {
        return dao.getAll();
    }

    @Override
    public Optional<BankClient> getById(long id) {
        return dao.getById(id);
    }

    @Override
    public boolean deleteById(long id) {
        return dao.deleteById(id);
    }

    @Override
    public BankClient update(BankClient client) {
        return dao.update(client);
    }

    @Override
    public BankClient save(BankClient client) {
        return dao.save(client);

    }


	public ClientPersistance getDao() {
		return dao;
	}


	public void setDao(ClientPersistance dao) {
		this.dao = dao;
	}
    
}
