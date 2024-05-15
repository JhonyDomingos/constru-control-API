package com.construcontrol.construcontrol.controllers;

import com.construcontrol.construcontrol.DTO.ClientsDTO;
import com.construcontrol.construcontrol.model.domain.Clients;
import com.construcontrol.construcontrol.model.domain.MaritialStatus;
import com.construcontrol.construcontrol.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
 @RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientRepository clientReposirtory;

    @GetMapping
   public ResponseEntity getAllClients() {
     var allClients = clientReposirtory.findAll();
        return ResponseEntity.ok(allClients);
   }

   @GetMapping("/{id}")
    public ResponseEntity getClientById(@PathVariable long id) {
        var client = clientReposirtory.getClientsById(id);
        return ResponseEntity.ok(client);
    }

   @PostMapping
    public ResponseEntity createClient(@RequestBody @Validated ClientsDTO payload) {

       Clients clients;
       try {
           clients = new Clients(payload);
           clientReposirtory.save(clients);
           System.out.println(payload);
           return ResponseEntity.ok().build();
       } catch (Exception e) {
           System.out.println(payload);
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar o cliente: " + e.getMessage());
       }
   }
}