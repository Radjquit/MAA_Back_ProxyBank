package org.maaProxyBack.persistance;

import org.maaProxyBack.model.BankClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<BankClient,Long> {
}
