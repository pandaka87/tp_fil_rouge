package fr.groupe_3.fil_rouge.controller;

import fr.groupe_3.fil_rouge.entity.Clients;
import fr.groupe_3.fil_rouge.service.ClientsService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ClientsController {

  @Autowired
  ClientsService clientService;

  @GetMapping("clients")
  public List<Clients> getClients() {
    return clientService.getAllClients();
  }

  @GetMapping("clients/{id}")
  public ResponseEntity<Clients> getClientById(@PathVariable("id") Integer id) {
    Optional<Clients> cOptional = clientService.getOneClientById(id);

    if (cOptional.isPresent()) {
      Clients client = cOptional.get();

      return ResponseEntity.ok(client);
    }

    return ResponseEntity.notFound().build();
  }

  @PostMapping("clients")
  public ResponseEntity<Clients> saveClient(@RequestBody Clients client) {
    Clients c = clientService.addClient(client);

    return ResponseEntity.ok(c);
  }

  @DeleteMapping("clients/{id}")
  public ResponseEntity<String> deleteClient(@PathVariable("id") Integer id) {
    if (clientService.getOneClientById(id).isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    clientService.deleteById(id);
    return ResponseEntity.ok("client a été supprimé");
  }

  @PutMapping("clients/{id}")
  public ResponseEntity<Clients> putClient(
      @PathVariable("id") Integer id,
      @RequestBody Clients updatedClient) {
    // id en Json et id en body
    if (!id.equals(updatedClient.getId())) {
      return ResponseEntity.badRequest().build();
    }
    if (clientService.getOneClientById(id).isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    clientService.updatedClient(id, updatedClient);
    return ResponseEntity.ok(updatedClient);
  }
}
