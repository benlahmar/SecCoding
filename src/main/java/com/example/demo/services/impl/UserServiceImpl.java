package com.example.demo.services.impl;

import com.example.demo.entities.User;
import com.example.demo.entities.Admin;
import com.example.demo.repositories.UserRepository;
import com.example.demo.repositories.AdminRepository;
import com.example.demo.repositories.AdminRepository2;
import com.example.demo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implémentation du service UserService qui gère les utilisateurs et administrateurs.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private AdminRepository2 adminRepository2;

    @Autowired
    private AdminRepository adminRepository;

    // Gestion des utilisateurs
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long userId, User userDetails) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            user.setRoles(userDetails.getRoles());
            return userRepository.save(user);
        }
        throw new RuntimeException("Utilisateur non trouvé avec l'ID : " + userId);
    }

    @Override
    public void deleteUser(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            userRepository.delete(optionalUser.get());
        } else {
            throw new RuntimeException("Utilisateur non trouvé avec l'ID : " + userId);
        }
    }

    @Override
    public Optional<User> findUserById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    // Gestion des administrateurs
    @Override
    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin updateAdmin(Long adminId, Admin adminDetails) {
        Optional<Admin> optionalAdmin = adminRepository.findById(adminId);
        if (optionalAdmin.isPresent()) {
            Admin admin = optionalAdmin.get();
            admin.setName(adminDetails.getName());
            admin.setEmail(adminDetails.getEmail());
            admin.setPassword(adminDetails.getPassword());
            return adminRepository.save(admin);
        }
        throw new RuntimeException("Administrateur non trouvé avec l'ID : " + adminId);
    }

    @Override
    public void deleteAdmin(Long adminId) {
        Optional<Admin> optionalAdmin = adminRepository.findById(adminId);
        if (optionalAdmin.isPresent()) {
            adminRepository.delete(optionalAdmin.get());
        } else {
            throw new RuntimeException("Administrateur non trouvé avec l'ID : " + adminId);
        }
    }

    @Override
    public Optional<Admin> findAdminById(Long adminId) {
        return adminRepository.findById(adminId);
    }

    @Override
    public List<Admin> findAllAdmins() {
        return adminRepository.findAll();
    }
    
    
    public Admin authenticate(String username, String password) {
        // Utilisation de la méthode vulnérable à l'injection SQL
        List<Admin> admins = adminRepository.findAdminByEmailAndPassword(username, password);
        if(!admins.isEmpty())
        return admins.get(0); // Si un admin est trouvé, l'authentification est validée
        else
        	return null;
    }
    
    public Admin authenticate2(String username, String password) {
        // Utilisation de la méthode vulnérable à l'injection SQL
        List<Admin> admins = adminRepository2.findAdminByEmailAndPassword2(username, password);
        if(!admins.isEmpty())
        return admins.get(0); // Si un admin est trouvé, l'authentification est validée
        else
        	return null;
    }
}
