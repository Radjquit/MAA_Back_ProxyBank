package org.maaProxyBack.controller;

import java.util.List;
import java.util.Optional;

import org.maaProxyBack.model.Account;
import org.maaProxyBack.model.BankClient;
import org.maaProxyBack.model.CurrentAccount;
import org.maaProxyBack.service.AccountService;
import org.maaProxyBack.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("accounts")

public class AccountController {

    private ClientService service;
    private AccountService serviceAccount;

    public AccountController(ClientService service, AccountService serviceAccount) {
        this.service = service;
        this.serviceAccount = serviceAccount;
    }

    @GetMapping
    public List<Account> getAllClients(){
        return serviceAccount.getAllAccounts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getById(@PathVariable long id){
        Optional<Account> getAccount = serviceAccount.getAccountById(id);
        /*
        if (getClient.isPresent()){

            return ResponseEntity.ok(getClient.get());
        }
        return ResponseEntity.notFound().build();
        */
        return getAccount.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/clientId")
    public List<Account> getAccountByClientId(@RequestParam(name="id",required=false) long id){
       return serviceAccount.getAccountsByClient(service.getById(id).orElse(new BankClient()));
        /*
        if (getClient.isPresent()){

            return ResponseEntity.ok(getClient.get());
        }
        return ResponseEntity.notFound().build();
        */
    }

    @PostMapping
    public void postAccount(@RequestBody @Valid CurrentAccount account, long id){
    	account.setClient(service.getById(id).get());
    		service.getById(id).get().getCurrentAccounts().add(account);
        serviceAccount.save(account);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable long id){
       serviceAccount.deleteById(id);
    }
    
    @PutMapping("/{id}")
    private ResponseEntity<CurrentAccount> updateAccount(@PathVariable long id, @RequestBody CurrentAccount account) {
    	serviceAccount.save(account);
    	return null;
	}
}
