package com.example.demo.repositories;

import com.example.demo.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository pour l'entité OrderItem, permettant de gérer les opérations CRUD.
 */
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
