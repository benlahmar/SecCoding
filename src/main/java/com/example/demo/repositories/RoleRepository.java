package com.example.demo.repositories;

import com.example.demo.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository pour l'entité Role, permettant de gérer les opérations CRUD.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}
