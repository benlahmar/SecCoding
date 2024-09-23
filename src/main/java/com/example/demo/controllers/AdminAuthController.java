package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Admin;
import com.example.demo.services.UserService;

@Controller
public class AdminAuthController {

	@Autowired
    private UserService userService;
	
    // Afficher la page de login pour l'administrateur
    @GetMapping("/admin/login")
    public String showAdminLoginPage(Model model) {
        return "admin-login"; // Le nom du fichier HTML sans extension
    }

    // Traiter la soumission du formulaire
    @PostMapping("/admin/login")
    public String adminLogin(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             Model model) {
        // Logique simple d'authentification
    	Admin adm = userService.authenticate2(username, password);
        if (adm!=null) {
            return "redirect:/management"; // Rediriger vers la page de gestion si authentifié
        } else {
            model.addAttribute("error", "Nom d'utilisateur ou mot de passe incorrect");
            return "admin-login"; // Retourner à la page de login en cas d'erreur
        }
    }
}
