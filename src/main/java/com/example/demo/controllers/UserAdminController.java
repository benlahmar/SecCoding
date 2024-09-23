package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.entities.Admin;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class UserAdminController {

    @Autowired
    private UserService userService;

    // Afficher la liste des utilisateurs et des administrateurs
    @GetMapping("/management")
    public String userAdminManagement(Model model) {
        List<User> users = userService.findAllUsers();
        List<Admin> admins = userService.findAllAdmins();
        model.addAttribute("users", users);
        model.addAttribute("admins", admins);
        return "user-admin-management";
    }

    // Afficher le formulaire pour ajouter un nouvel utilisateur
    @GetMapping("/users/add")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    // Sauvegarder un nouvel utilisateur
    @PostMapping("/users/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/management";
    }

    // Afficher le formulaire pour modifier un utilisateur existant
    @GetMapping("/users/edit/{id}")
    public String showEditUserForm(@PathVariable("id") Long id, Model model) {
        Optional<User> user = userService.findUserById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "user-form";
        }
        return "redirect:/management";
    }

    // Mettre à jour un utilisateur existant
    @PostMapping("/users/update/{id}")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute("user") User user) {
        userService.updateUser(id, user);
        return "redirect:/management";
    }

    // Supprimer un utilisateur
    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/management";
    }

    // Afficher le formulaire pour ajouter un nouvel administrateur
    @GetMapping("/admins/add")
    public String showAddAdminForm(Model model) {
        model.addAttribute("admin", new Admin());
        return "admin-form";
    }

    // Sauvegarder un nouvel administrateur
    @PostMapping("/admins/save")
    public String saveAdmin(@ModelAttribute("admin") Admin admin) {
        userService.createAdmin(admin);
        return "redirect:/management";
    }

    // Afficher le formulaire pour modifier un administrateur existant
    @GetMapping("/admins/edit/{id}")
    public String showEditAdminForm(@PathVariable("id") Long id, Model model) {
        Optional<Admin> admin = userService.findAdminById(id);
        if (admin.isPresent()) {
            model.addAttribute("admin", admin.get());
            return "admin-form";
        }
        return "redirect:/management";
    }

    // Mettre à jour un administrateur existant
    @PostMapping("/admins/update/{id}")
    public String updateAdmin(@PathVariable("id") Long id, @ModelAttribute("admin") Admin admin) {
        userService.updateAdmin(id, admin);
        return "redirect:/management";
    }

    // Supprimer un administrateur
    @GetMapping("/admins/delete/{id}")
    public String deleteAdmin(@PathVariable("id") Long id) {
        userService.deleteAdmin(id);
        return "redirect:/management";
    }
}
