package com.example.demo.repositories;

import com.example.demo.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository pour l'entité Inventory, permettant de gérer les opérations CRUD.
 */
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
