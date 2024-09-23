package com.example.demo.repositories;

import com.example.demo.entities.Admin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Repository pour l'entité Admin, permettant de gérer les opérations CRUD.
 */
public interface AdminRepository extends JpaRepository<Admin, Long> {
	
    @Query(value = "SELECT * FROM admin WHERE email = ?1 AND password = ?2", nativeQuery = true)
    List<Admin> findAdminByEmailAndPassword(String email, String password);
}
