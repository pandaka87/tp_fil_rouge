package fr.groupe_3.fil_rouge.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.groupe_3.fil_rouge.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer>{
    
}
