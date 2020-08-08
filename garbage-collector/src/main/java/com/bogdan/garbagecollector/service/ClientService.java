package com.bogdan.garbagecollector.service;

import com.bogdan.garbagecollector.dto.ClientDTO;
import com.bogdan.garbagecollector.entity.Client;
import com.bogdan.garbagecollector.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public String create(ClientDTO clientDTO) {
        return clientRepository.create(convertDTOToClient().apply(clientDTO));
    }

    public List<ClientDTO> readAll() {
        return clientRepository.readAll()
                               .stream()
                               .map(convertClientToDTO())
                               .collect(Collectors.toList());
    }

    public ClientDTO readByID(int id) {
        Client clientByIdOrThrow = getClientByIdOrThrow(id);
        return convertClientToDTO().apply(clientByIdOrThrow);
    }

    private Client getClientByIdOrThrow(int id) {
        return clientRepository.getClientById(id)
                               .orElseThrow(() -> new IllegalArgumentException("There is no client with the id " + id));
    }

    public String update(int id, ClientDTO client) {
        Client clientToBeUpdated = getClientByIdOrThrow(id);
        setNewValues(clientToBeUpdated, client);
        return "ok";
    }

    private void setNewValues(Client clientToBeUpdated, ClientDTO newClient) {
        clientToBeUpdated.setId(newClient.getId());
        clientToBeUpdated.setName(newClient.getName());
    }

    private Function<Client, ClientDTO> convertClientToDTO() {
        return client -> new ClientDTO(client.getId(), client.getName());
    }

    private Function<ClientDTO, Client> convertDTOToClient() {
        return clientDTO -> new Client(clientDTO.getId(), clientDTO.getName());
    }

    public String delete(int id) {
        return clientRepository.delete(id);
    }
}
