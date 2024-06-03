package org.maaProxyBack.controller;

import java.util.List;
import java.util.Optional;

import org.maaProxyBack.model.Client;
import org.maaProxyBack.model.Client2;
import org.maaProxyBack.service.ClientService;
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
@RequestMapping("clients")
public class ClientController {
    private ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping
    public List<Client2> getAllClients(){return service.getAll();}

    @GetMapping("/{id}")
    public ResponseEntity<Client2> getById(@PathVariable long id){
        Optional<Client2> getClient = service.getById(id);
        /*
        if (getClient.isPresent()){

            return ResponseEntity.ok(getClient.get());
        }
        return ResponseEntity.notFound().build();
        */
        return getClient.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public void postClient(@RequestBody @Valid Client2 client){
        client.getCurrentAccounts().forEach(ca->ca.setClient(client));
        client.getSavingAccounts().forEach(ca->ca.setClient(client));
        service.save(client);
        System.out.println(client.toString() + "Controller");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Client2> deleteClient(@PathVariable long id){
        boolean deleted = service.deleteById(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
