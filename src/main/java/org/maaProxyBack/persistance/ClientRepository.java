package org.maaProxyBack.persistance;

import org.maaProxyBack.model.Client;
import org.maaProxyBack.model.Client2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client2,Long> {
}
