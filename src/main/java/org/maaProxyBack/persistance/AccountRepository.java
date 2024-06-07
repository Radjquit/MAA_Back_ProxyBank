package org.maaProxyBack.persistance;

import java.util.List;

import org.maaProxyBack.model.Account;
import org.maaProxyBack.model.BankClient;
import org.maaProxyBack.model.CurrentAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

	List<Account> findByClient(BankClient client);
	void deleteByClient(BankClient client);
	
}
