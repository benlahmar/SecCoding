package com.example.demo.repositories;


import com.example.demo.entities.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository pour l'entité Shipping, permettant de gérer les opérations CRUD.
 */
public interface ShippingRepository extends JpaRepository<Shipping, Long> {
}
