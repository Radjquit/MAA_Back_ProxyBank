package org.maaProxyBack.service;

import java.util.List;
import java.util.Optional;

import org.maaProxyBack.model.Advisor;
import org.maaProxyBack.model.BankClient;

public interface AdvisorService {

	List<Advisor> getAll();
    Optional<Advisor> getById(long id);
    Advisor update(Advisor advisor);
    Advisor save(Advisor advisor);
    void deleteById(long id);
}
