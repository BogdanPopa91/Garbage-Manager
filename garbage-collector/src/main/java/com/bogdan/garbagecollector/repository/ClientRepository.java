package com.bogdan.garbagecollector.repository;

import com.bogdan.garbagecollector.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    private List<Client> clients;

    @Autowired
    public ClientRepository() {
        clients = new ArrayList<>();
    }

    @PostConstruct
    public void initialize() {
        clients.add(new Client(1,"Ericson"));
        clients.add(new Client(2,"IBM"));
    }

    public String create(Client client) {
        clients.add(client);
        return "ok";
    }

    public List<Client> readAll() {
        return clients;
    }

/*    public Client getByID(int id) {
        for (Client client : clients) {
            if (client.getId() == (id))
                return client;
        }
        return null;
    }*/
    public Optional<Client> getClientById(int id) {
        return getOptionalClientById(id);
    }

    public Optional<Client> getOptionalClientById(int id) {
        return clients.stream()
               .filter(client -> client.getId() == id)
               .findFirst();
    }

    public String delete(int id) {
       /* Iterator<Client> iterator = clients.iterator();
        while (iterator.hasNext()) {
            Client element = iterator.next();
            if (element.getId() == id) {
                iterator.remove();
                return "ok";
            }
        }
        return "not ok"; */

     /*   for (Client client : clients) {
            if (client.getId() == id) {
                clients.remove(client);
                return "ok";
            }
        }
        return "not ok"; */
        clients.remove(getOptionalClientById(id)); //TODO: fix this!
        return "ok";
    }
}
