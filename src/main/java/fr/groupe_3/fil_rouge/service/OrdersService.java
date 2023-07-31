package fr.groupe_3.fil_rouge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.groupe_3.fil_rouge.dao.OrdersRepository;
import fr.groupe_3.fil_rouge.entity.Orders;

@Service
public class OrdersService {

    @Autowired
    OrdersRepository ordersRepository;

    public void addOrders(Orders neworders) {
        ordersRepository.save(neworders);
    }

    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    public void deleteOrders(int id) {
        ordersRepository.deleteById(id);
    }

    public Optional<Orders> getOneOrders(Integer id) {
        return ordersRepository.findById(id);
    }

    public boolean updateOrders(Orders order, Integer id) {
        Optional<Orders> optional = ordersRepository.findById(id);
        if (optional.isPresent()) {
            ordersRepository.save(order);
            return true;
        } else {
            return false;
        }
    }
}