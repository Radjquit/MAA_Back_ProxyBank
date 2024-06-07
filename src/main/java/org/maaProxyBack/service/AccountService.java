package org.maaProxyBack.service;

import java.util.List;
import java.util.Optional;

import org.maaProxyBack.model.Account;
import org.maaProxyBack.model.BankClient;
import org.maaProxyBack.model.CurrentAccount;

public interface AccountService {
	
	List<Account> getAllAccounts();
	
	List<Account> getAccountsByClient(BankClient client);

	Optional<Account> getAccountById(long id);

	void deleteById(long id);

	Account save(Account account);
	
}
