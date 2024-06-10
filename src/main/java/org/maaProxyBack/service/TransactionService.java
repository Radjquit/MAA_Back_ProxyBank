package org.maaProxyBack.service;

import java.util.List;
import java.util.Optional;

import org.maaProxyBack.exception.BankException;
import org.maaProxyBack.model.Transaction;

public interface TransactionService {

	List<Transaction> getAllTransactions();
	
//	List<Transaction> getTransactionsByAccount(Account account);

	Optional<Transaction> getTransactionByID(long id);

	void deleteById(long id);

	Transaction save(Transaction transac);
	
	public void transfer(long idAccDeb, long idAccCred, Transaction transacÒ)throws BankException;
}
