package fr.groupe_3.fil_rouge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.groupe_3.fil_rouge.dao.ClientRepo;
import fr.groupe_3.fil_rouge.entity.Client;

@Service
public class ClientService {

    @Autowired
    ClientRepo clientRepo;

    // Get all
    public List<Client> getAllClients() {
        return clientRepo.findAll();
    }

    // Get one
    public Optional<Client> getOneClientById(Long id) {
        return clientRepo.findById(id);
    }

    // Delete one
    public void deleteById(Long id) {
        clientRepo.deleteById(id);
    }

    // Post one
    public Client addClient(Client client) {
        return clientRepo.save(client);
    }

    // Put
    public void updatedClient(Long id, Client client) {
        clientRepo.save(client);
    }

}