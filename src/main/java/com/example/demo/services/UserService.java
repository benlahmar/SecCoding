package com.example.demo.services;


import com.example.demo.entities.User;
import com.example.demo.entities.Admin;

import java.util.List;
import java.util.Optional;

/**
 * Interface du service pour la gestion des utilisateurs et des administrateurs.
 * Contient les méthodes pour créer, mettre à jour, supprimer et rechercher des utilisateurs et des administrateurs.
 */
public interface UserService {

    // Méthodes pour les utilisateurs
    User createUser(User user);

    User updateUser(Long userId, User user);

    void deleteUser(Long userId);

    Optional<User> findUserById(Long userId);

    Optional<User> findUserByEmail(String email);

    List<User> findAllUsers();

    // Méthodes pour les administrateurs
    Admin createAdmin(Admin admin);

    Admin updateAdmin(Long adminId, Admin admin);

    void deleteAdmin(Long adminId);

    Optional<Admin> findAdminById(Long adminId);

    List<Admin> findAllAdmins();
    
    Admin authenticate(String username, String password);
    Admin authenticate2(String username, String password);

}
