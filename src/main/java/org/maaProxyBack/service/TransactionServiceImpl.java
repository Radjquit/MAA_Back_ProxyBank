package org.maaProxyBack.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.maaProxyBack.exception.BankException;
import org.maaProxyBack.model.Account;
import org.maaProxyBack.model.Transaction;
import org.maaProxyBack.persistance.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TransactionServiceImpl implements TransactionService {
	TransactionRepository transacDao;
	AccountService accService;
	
	

	public TransactionServiceImpl(TransactionRepository transacDao, AccountService accService) {
		this.transacDao = transacDao;
		this.accService = accService;
	}

	@Override
	public List<Transaction> getAllTransactions() {
		return transacDao.findAll();
	}

//	@Override
//	public List<Transaction> getTransactionsByAccount(Account account) {
//		return transacDao.;
//	}

	@Override
	public Optional<Transaction> getTransactionByID(long id) {
		return transacDao.findById(id);
	}

	@Override
	public void deleteById(long id) {
		transacDao.deleteById(id);
		
	}

	@Override
	public Transaction save(Transaction transac) {
		return transacDao.save(transac);
	}
	
	
	@Transactional()
	public void transfer(long idAccDeb, long idAccCred, Transaction transac)throws BankException {
		try {
			Account accDeb = accService.getAccountById(idAccDeb).get();
			accDeb.setBalance(accDeb.getBalance() - transac.getAmount());
			accService.save(accDeb);
			//Operation(Long numero, String label, Double montant, Date dateOp)
			Transaction transacDebit=new Transaction(null,"Débit : " +transac.getLabel(),-transac.getAmount(),new Date());
			transacDebit.setAccount(accDeb);
			transacDao.save(transacDebit);
			
			Account accCred = accService.getAccountById(idAccCred).get();
			accCred.setBalance(accCred.getBalance() + transac.getAmount());
			accService.save(accCred);
			Transaction transacCredit= new Transaction(null,"Credit : " +transac.getLabel(),transac.getAmount(),new Date());
			transacCredit.setAccount(accCred);
			transacDao.save(transacCredit);
		} catch (Exception e) {
			throw new BankException("echec virement",e);
		}
	}

}
