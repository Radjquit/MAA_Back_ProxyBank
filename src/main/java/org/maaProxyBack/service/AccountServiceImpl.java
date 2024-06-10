package org.maaProxyBack.service;

import java.util.List;
import java.util.Optional;

import org.maaProxyBack.model.Account;
import org.maaProxyBack.model.BankClient;
import org.maaProxyBack.persistance.AccountRepository;
import org.maaProxyBack.persistance.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
	

    private AccountRepository accountDao;
    
    public AccountServiceImpl(AccountRepository accountDao) {

        this.accountDao = accountDao;
    }

	@Override
	public List<Account> getAllAccounts() {
		return accountDao.findAll();
	}

	@Override
	public List<Account> getAccountsByClient(BankClient client) {
		return accountDao.findByClient(client);
	}

	@Override
	public Optional<Account> getAccountById(long id) {
		return accountDao.findById(id);
	}

	@Override
	public void deleteById(long id) {
		accountDao.deleteById(id);
	}

	@Override
	public Account save(Account account) {
		return accountDao.save(account);
	}

}
