package com.facundo.javaDocker.service;

import com.facundo.javaDocker.models.Client;

import java.util.List;

public interface ClientService {

    List<Client> getAllClients();
    Client getClientById(Long id);

    Client findClietnByEmail(String email);

    void saveClient(Client client);

    void deleteClient(Client client);
}
