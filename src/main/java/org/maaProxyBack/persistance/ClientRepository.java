package org.maaProxyBack.persistance;

import org.maaProxyBack.model.Client;
import org.maaProxyBack.model.Client2;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client2,Long> {
    public List<Client2> findByAdvisor_id(long id);
    public List<Client2> findByAdvisorId(long id);

}
