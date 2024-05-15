package org.maaProxyBack.controller;

import jakarta.validation.Valid;
import org.maaProxyBack.model.Client;
import org.maaProxyBack.service.ClientService;
import org.maaProxyBack.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("clients")
public class ClientController {
    private ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping
    public List<Client> getAllClients(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getById(@PathVariable long id){
        Optional<Client> getClient = service.getById(id);
        /*
        if (getClient.isPresent()){

            return ResponseEntity.ok(getClient.get());
        }
        return ResponseEntity.notFound().build();
        */
        return getClient.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public void postClient(@RequestBody @Valid Client client){
        service.save(client);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable long id){
        boolean deleted = service.deleteById(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
