package com.facundo.javaDocker.service.implement;

import com.facundo.javaDocker.models.Client;
import com.facundo.javaDocker.repositories.ClientRepository;
import com.facundo.javaDocker.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceClientImp implements ClientService {

    @Autowired
    ClientRepository clientRepository;
    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public Client findClietnByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    @Override
    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void deleteClient(Client client) {
        clientRepository.save(client);
    }

}
