package org.maaProxyBack.controller;

import java.util.List;
import java.util.Optional;

import org.maaProxyBack.model.Transaction;
import org.maaProxyBack.service.AccountService;
import org.maaProxyBack.service.ClientService;
import org.maaProxyBack.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("transactions")
public class TransactionController {
	private ClientService service;
    private AccountService serviceAccount;
    private TransactionService transacService;

    public TransactionController(ClientService service, AccountService serviceAccount, TransactionService transacService) {
        this.service = service;
        this.serviceAccount = serviceAccount;
        this.transacService = transacService;
    }

    @GetMapping
    public List<Transaction> getAllTransactions(){
        return transacService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getById(@PathVariable long id){
        Optional<Transaction> getTransac = transacService.getTransactionByID(id);
        return getTransac.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping("/{idDeb}/{idCred}")
    public void postTransaction(@PathVariable long idDeb ,@PathVariable long idCred,@RequestBody @Valid Transaction transac){
    	transacService.transfer(idDeb, idCred, transac);
    }


    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable long id){
       transacService.deleteById(id);
    }
    
}
