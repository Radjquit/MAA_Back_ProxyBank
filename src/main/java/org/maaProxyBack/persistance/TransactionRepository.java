package org.maaProxyBack.persistance;

import org.maaProxyBack.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
