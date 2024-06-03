package org.maaProxyBack.persistance;

import org.maaProxyBack.model.BankClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<BankClient,Long> {
    public List<BankClient> findByAdvisor_id(long id);
    public List<BankClient> findByAdvisorId(long id);

}
