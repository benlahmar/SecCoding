package com.example.demo.repositories;

import com.example.demo.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository pour l'entité Supplier, permettant de gérer les opérations CRUD.
 */
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
