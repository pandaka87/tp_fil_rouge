package fr.groupe_3.fil_rouge.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.groupe_3.fil_rouge.entity.Client;
import fr.groupe_3.fil_rouge.service.ClientService;

@RestController
@RequestMapping("api")
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping("clients")
    public List<Client> getClients() {

        return clientService.getAllClients();
    }

    @GetMapping("clients/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") Integer id) {
        Optional<Client> cOptional = clientService.getOneClientById(id);

        if (cOptional.isPresent()) {

            Client client = cOptional.get();

            return ResponseEntity.ok(client);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("clients")
    public ResponseEntity<Client> saveClient(@RequestBody Client client) {

        Client c = clientService.addClient(client);

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
    public ResponseEntity<Client> putClient(@PathVariable("id") Integer id, @RequestBody Client updatedClient) {

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

    @PatchMapping("clients/{id}")
    public ResponseEntity<Object> patchClient(@PathVariable("id") Integer id, @RequestBody Client patchedClient) {

        // id en Json et id en body
        if (!id.equals(patchedClient.getId())) {
            return ResponseEntity.badRequest().build();

        }
        if (clientService.getOneClientById(id).isEmpty()) {
            return ResponseEntity.notFound().build();

        }

        clientService.patchClient(id, patchedClient);
        return ResponseEntity.ok(clientService.getOneClientById(id));

    }

}
