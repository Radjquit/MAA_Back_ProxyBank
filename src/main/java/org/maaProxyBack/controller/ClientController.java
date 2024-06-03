package org.maaProxyBack.controller;

import java.util.List;
import java.util.Optional;

import org.maaProxyBack.model.BankClient;
import org.maaProxyBack.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("clients")
public class ClientController {
    private ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping

    public List<BankClient> getAllClients(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankClient> getById(@PathVariable long id){
        Optional<BankClient> getClient = service.getById(id);
        /*
        if (getClient.isPresent()){

            return ResponseEntity.ok(getClient.get());
        }
        return ResponseEntity.notFound().build();
        */
        return getClient.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public void postClient(@RequestBody @Valid BankClient client){
        client.getCurrentAccounts().forEach(ca->ca.setClient(client));
        client.getSavingAccounts().forEach(ca->ca.setClient(client));
        service.save(client);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BankClient> deleteClient(@PathVariable long id){
        boolean deleted = service.deleteById(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
    
    @PutMapping("/{id}")
    private ResponseEntity<BankClient> updateClient(@PathVariable long id, @RequestBody BankClient client) {
    	service.update(client);
    	return null;
	}

}
