package org.maaProxyBack.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.maaProxyBack.dto.AccountDto;
import org.maaProxyBack.model.Account;
import org.maaProxyBack.model.BankClient;
import org.maaProxyBack.model.CurrentAccount;
import org.maaProxyBack.model.SavingAccount;
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
    public List<AccountDto> getAllAccounts(){
    	List <AccountDto> accountsDto = new ArrayList<>();
    	List <Account> accounts = serviceAccount.getAllAccounts();
    	for (Account account : accounts) {
			if(account.getClass()== CurrentAccount.class) {
				accountsDto.add(new AccountDto(account.getAccountNumber(),account.getBalance(),"Running", account.getCategory()));
			}else {
				accountsDto.add(new AccountDto(account.getAccountNumber(),account.getBalance(),"Saving", account.getCategory()));
			}
		}
    	return accountsDto;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getById(@PathVariable long id){
        Optional<Account> getAccount = serviceAccount.getAccountById(id);
        return getAccount.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/clientId")
    public List<Account> getAccountByClientId(@RequestParam(name="id",required=false) long id){
       return serviceAccount.getAccountsByClient(service.getById(id).get());
    }

    @PostMapping("/{id}")
    public Account postAccount(@PathVariable long id,@RequestBody @Valid AccountDto accountDto){
    	if(accountDto.getType().equalsIgnoreCase("Running")) {
    		CurrentAccount account = new CurrentAccount();
    		account.setBalance(accountDto.getBalance());
    		account.setCategory(accountDto.getCategory());
    		account.setClient(service.getById(id).get());
    		service.getById(id).get().getCurrentAccounts().add(account);
    		return serviceAccount.save(account);
    	}else{
    		SavingAccount account = new SavingAccount();
    		account.setBalance(accountDto.getBalance());
    		account.setCategory(accountDto.getCategory());
    		account.setClient(service.getById(id).get());
    		service.getById(id).get().getSavingAccounts().add(account);
    		return serviceAccount.save(account);
    	}
    }


    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable long id){
       serviceAccount.deleteById(id);
    }
    
    @PutMapping("/{id}")
    private Account updateAccount(@PathVariable long id, @RequestBody AccountDto accountDto) {
    	return postAccount(id, accountDto);
	}
}
