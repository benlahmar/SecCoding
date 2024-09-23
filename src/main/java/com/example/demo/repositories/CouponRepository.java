package com.example.demo.repositories;

import com.example.demo.entities.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository pour l'entité Coupon, permettant de gérer les opérations CRUD.
 */
public interface CouponRepository extends JpaRepository<Coupon, Long> {
}
