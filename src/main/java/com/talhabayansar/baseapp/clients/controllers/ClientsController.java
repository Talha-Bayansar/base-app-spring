package com.talhabayansar.baseapp.clients.controllers;

import com.talhabayansar.baseapp.clients.entities.Client;
import com.talhabayansar.baseapp.clients.entities.ClientDto;
import com.talhabayansar.baseapp.clients.services.ClientsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientsController {
    @Autowired
    private ClientsServiceImpl clientsService;


    @GetMapping()
    public ResponseEntity<Iterable<Client>> findAll(@RequestParam(value = "limit", required = false, defaultValue = "") String limit,
                                          @RequestParam(value = "offset", required = false, defaultValue = "0") String offset) {
        return ResponseEntity.ok(this.clientsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findOne(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.clientsService.findOne(id));
    }

    @PostMapping()
    public ResponseEntity<Client> create(@RequestBody ClientDto body) {
        Client client = this.clientsService.create(body);
        return ResponseEntity.ok(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable("id") Integer id, @RequestBody ClientDto body) {
        Client client = this.clientsService.update(id, body);
        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Client> remove(@PathVariable("id") Integer id) {
        Client client = this.clientsService.remove(id);
        return ResponseEntity.ok(client);
    }
}
