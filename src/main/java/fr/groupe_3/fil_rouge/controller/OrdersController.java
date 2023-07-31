package fr.groupe_3.fil_rouge.controller;

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

import fr.groupe_3.fil_rouge.entity.Orders;
import fr.groupe_3.fil_rouge.service.OrdersService;

@RestController
@RequestMapping("api")
public class OrdersController {

    // Injection
    @Autowired
    OrdersService ordersService;

    // Méthode GET ALL
    @GetMapping("orders")
    public List<Orders> getAllOrders() {
        return ordersService.getAllOrders();
    }

    // Méthode GET ONE
    @GetMapping("orders/{id}")
    public ResponseEntity<Orders> getOneOrders(@PathVariable("id") Integer id) {
        Optional<Orders> optional = ordersService.getOneOrders(id);

        if (optional.isPresent()) {
            Orders orders = optional.get();
            return ResponseEntity.ok(orders);
        } else {// if(optional.isEmpty())
            return ResponseEntity.notFound().build();
        }
    }

    // Méthode POST
    @PostMapping("orders")
    public void postOrders(@RequestBody Orders newOrders) {
        System.out.println(newOrders);
        ordersService.addOrders(newOrders);
    }

    // Méthode DELETE
    @DeleteMapping("orders/{id}")
    public void deleteOrders(@PathVariable("id") Integer id) {
        ordersService.deleteOrders(id);
    }

    // Méthode PUT (modify/edit)
    @PutMapping("orders/{id}")
    public ResponseEntity<Orders> putOrders(@PathVariable("id") Integer id, @RequestBody Orders orders) {

        if (!id.equals(orders.getId())) {
            return ResponseEntity.badRequest().build();
        }

        if (ordersService.getOneOrders(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        ordersService.updateOrders(orders, id);
        return ResponseEntity.ok().build();
    }
}