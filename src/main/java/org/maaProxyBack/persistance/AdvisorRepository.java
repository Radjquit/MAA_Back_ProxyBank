package org.maaProxyBack.persistance;

import org.maaProxyBack.model.Advisor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvisorRepository extends JpaRepository<Advisor,Long> {
}
