package org.maaProxyBack.service;

import java.util.List;
import java.util.Optional;

import org.maaProxyBack.model.BankClient;
import org.maaProxyBack.persistance.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository dao;
    
    public ClientServiceImpl(ClientRepository dao) {
        this.dao=dao;
    }

	@Override
    public List<BankClient> getAll() {
        return dao.findAll();
    }

    @Override
    public Optional<BankClient> getById(long id) {
        return dao.findById(id);
    }

    @Override
    public void deleteById(long id) {
         dao.deleteById(id);;
    }

    @Override
    public BankClient update(BankClient client) {
        return dao.save(client);
    }

    @Override
    public BankClient save(BankClient client) {
        return dao.save(client);

    }

	public ClientRepository getDao() {
		return dao;
	}

	public void setDao(ClientRepository dao) {
		this.dao = dao;
	}

    public List<BankClient> getAllByAdvisor(long id){
        return dao.findByAdvisorId(id);
    }

    
    
}
