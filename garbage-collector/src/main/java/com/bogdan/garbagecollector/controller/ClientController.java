package com.bogdan.garbagecollector.controller;

import com.bogdan.garbagecollector.dto.ClientDTO;
import com.bogdan.garbagecollector.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public String create(@RequestBody ClientDTO clientDTO) {
        return clientService.create(clientDTO);
    }

    @GetMapping
    public List<ClientDTO> read() {
        return clientService.readAll();
    }

    @GetMapping(path = "/{id}")
    public ClientDTO readByID(@PathVariable int id) {
        return clientService.readByID(id);
    }

    @PutMapping(path = "/{id}")
    public String update( @PathVariable int id, @RequestBody ClientDTO newClient) {
        return clientService.update( id, newClient);
    }

    @DeleteMapping(path = "/{id}")
    public String delete(@PathVariable int id) {
        return clientService.delete(id);
    }
}
