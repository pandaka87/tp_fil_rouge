package fr.groupe_3.fil_rouge.service;

import fr.groupe_3.fil_rouge.dao.ClientsRepository;
import fr.groupe_3.fil_rouge.entity.Clients;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientsService {

  @Autowired
  ClientsRepository clientRepo;

  // Get all
  public List<Clients> getAllClients() {
    return clientRepo.findAll();
  }

  // Get one
  public Optional<Clients> getOneClientById(Integer id) {
    return clientRepo.findById(id);
  }

  // Delete one
  public void deleteById(Integer id) {
    clientRepo.deleteById(id);
  }

  // Post one
  public Clients addClient(Clients client) {
    return clientRepo.save(client);
  }

  // Put
  public void updatedClient(Integer id, Clients client) {
    clientRepo.save(client);
  }
}