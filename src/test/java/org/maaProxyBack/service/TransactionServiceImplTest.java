package org.maaProxyBack.service;

import org.junit.jupiter.api.Test;
import org.maaProxyBack.exception.BankException;
import org.maaProxyBack.model.Account;
import org.maaProxyBack.model.CurrentAccount;
import org.maaProxyBack.model.Transaction;
import org.maaProxyBack.persistance.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class TransactionServiceImplTest {

    @Autowired
    private TransactionService service;

    @MockBean
    private TransactionRepository mockTransactionRepo;

    @MockBean
    private AccountService mockAccountService;

    @Test
    void transfer_should_save_2_transactions() {
        long id1 = 1;
        long id2 = 2;
        Account acc1 = new CurrentAccount();
        acc1.setAccountNumber(id1);
        acc1.setBalance(1500);
        Optional<Account> accountOptional1 = Optional.of(acc1);
        Account acc2 = new CurrentAccount();
        acc2.setAccountNumber(id2);
        acc2.setBalance(3000);
        Optional<Account> accountOptional2 = Optional.of(acc2);

        Transaction transaction = new Transaction(null, "label", 1000.0, Date.from(Instant.now()));

        when(mockAccountService.getAccountById(id1)).thenReturn(accountOptional1);
        when(mockAccountService.getAccountById(id2)).thenReturn(accountOptional2);
        when(mockTransactionRepo.save(any(Transaction.class))).thenAnswer(invocation ->
                invocation.getArgument(0));

        service.transfer(id1, id2, transaction);

        verify(mockAccountService).getAccountById(id1);
        verify(mockAccountService).getAccountById(id2);
        verify(mockTransactionRepo, times(2)).save(any(Transaction.class));
    }

    @Test
    void transfer_should_not_create_transaction_if_amount_is_higher_than_authorized_overdraft() {
        long idDeb = 1;
        long idCred = 2;
        double balanceCred = 1500;

        CurrentAccount accDeb = new CurrentAccount();
        accDeb.setAccountNumber(idDeb);
        accDeb.setBalance(balanceCred);
        Optional<Account> accountOptional1 = Optional.of(accDeb);
        Account accCred = new CurrentAccount();
        accCred.setAccountNumber(idCred);
        accCred.setBalance(3000);
        Optional<Account> accountOptional2 = Optional.of(accCred);

        double transactionAmount = balanceCred + accDeb.getAuthorizedOverdraft() + 0.01;

        Transaction transaction = new Transaction(null, "label", transactionAmount, Date.from(Instant.now()));

        when(mockAccountService.getAccountById(idDeb)).thenReturn(accountOptional1);
        when(mockAccountService.getAccountById(idCred)).thenReturn(accountOptional2);
        when(mockTransactionRepo.save(any(Transaction.class))).thenAnswer(invocation ->
                invocation.getArgument(0));

        assertThrows(BankException.class,
                ()->service.transfer(idDeb, idCred, transaction));

        verify(mockAccountService).getAccountById(idDeb);
        verify(mockAccountService).getAccountById(idCred);
        //verify(mockTransactionRepo,atMost(1)).save(any(Transaction.class));
    }
}