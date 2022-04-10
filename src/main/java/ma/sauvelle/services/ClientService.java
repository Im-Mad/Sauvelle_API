package ma.sauvelle.services;

import ma.sauvelle.models.Client;

import java.util.List;

public interface ClientService {
    Client save(Client client);
    List<Client> findAll();
    Client findClientByUsername(String username);
}
