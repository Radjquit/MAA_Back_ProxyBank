package org.maaProxyBack.controller;

import java.util.List;
import java.util.Optional;

import org.maaProxyBack.model.Advisor;
import org.maaProxyBack.model.BankClient;
import org.maaProxyBack.service.AdvisorService;
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
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("advisor")
public class AdvisorController {
	@Autowired
	private AdvisorService service;
	
    @GetMapping
    public List<Advisor> getAllAdvisor(){
        return service.getAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Advisor> getAdvisorById(@PathVariable long id){
        Optional<Advisor> getAdvisor = service.getById(id);
        return getAdvisor.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping()
    public Advisor createAdvisor(@RequestBody @Valid Advisor advisor) {
    	return service.save(advisor);
    }
    
    @PutMapping("/{id}")
    public Advisor updateAdvisor(@PathVariable long id, @RequestBody Advisor advisor) {
       	return service.update(advisor);
    }
    
    
    @DeleteMapping("/{id}")
    public void deleteAdvisor(@PathVariable long id) {
    	service.deleteById(id);
    }

}
