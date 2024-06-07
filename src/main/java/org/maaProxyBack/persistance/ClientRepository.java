package org.maaProxyBack.persistance;

import java.util.List;

import org.maaProxyBack.model.BankClient;
import org.maaProxyBack.model.CurrentAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<BankClient, Long> {

	List<BankClient> findByAdvisorId(long id);
}
