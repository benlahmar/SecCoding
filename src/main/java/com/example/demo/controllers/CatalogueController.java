package com.example.demo.controllers;

import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CatalogueController {

    @Autowired
    private CatalogService catalogService;

    // 1. Liste des catégories pour la page des utilisateurs
    @GetMapping("/categories")
    public String listCategories(Model model) {
        List<Category> categories = catalogService.findAllCategories();
        model.addAttribute("categories", categories);
        return "categories-list";  // Renvoie à la vue categories-list.html
    }

    // 2. Liste des produits d'une catégorie
    @GetMapping("/categories/{id}/products")
    public String listProductsByCategory(@PathVariable("id") Long categoryId,
                                         @RequestParam(value = "search", required = false) String searchQuery,
                                         @RequestParam(value = "availability", required = false) String availabilityFilter,
                                         Model model) {
        // Charger la catégorie
        Category category = catalogService.findCategoryById(categoryId)
                .orElseThrow(() -> new RuntimeException("Catégorie non trouvée"));

        // Obtenir tous les produits de la catégorie
        List<Product> products = catalogService.findAllProductsByCategory(categoryId);

        // Filtrer par recherche
        if (searchQuery != null && !searchQuery.isEmpty()) {
            products = products.stream()
                    .filter(product -> product.getName().toLowerCase().contains(searchQuery.toLowerCase()))
                    .collect(Collectors.toList());
        }

     // Filtrer par disponibilité (si "en stock" ou "rupture de stock")
        if (availabilityFilter != null && !availabilityFilter.isEmpty()) {
            if ("inStock".equals(availabilityFilter)) {
                // Filtrer uniquement les produits en stock (qte > 0)
                products = products.stream()
                        .filter(product -> product.getQte() > 0)
                        .collect(Collectors.toList());
            } else if ("outOfStock".equals(availabilityFilter)) {
                // Filtrer uniquement les produits en rupture de stock (qte == 0)
                products = products.stream()
                        .filter(product -> product.getQte() == 0)
                        .collect(Collectors.toList());
            }
        }

        // Ajouter les données au modèle
        model.addAttribute("category", category);
        model.addAttribute("products", products);
        model.addAttribute("searchQuery", searchQuery);
        model.addAttribute("availabilityFilter", availabilityFilter);


        return "products-list";  // Renvoie à la vue products-list.html
    }
}
