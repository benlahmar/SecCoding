package com.example.demo.repositories;

import com.example.demo.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository pour l'entité Payment, permettant de gérer les opérations CRUD.
 */
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
