package com.example.demo.controllers;

import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile; // Pour gérer les fichiers téléchargés
import java.io.IOException; // Gestion des exceptions d'entrées/sorties
import java.io.InputStream; // Pour lire les fichiers téléchargés
import java.nio.file.Files; // Classe pour manipuler les fichiers
import java.nio.file.Path; // Représente un chemin dans le système de fichiers
import java.nio.file.Paths; // Pour créer des objets Path
import java.nio.file.StandardCopyOption; // Pour l'option de copie des fichiers
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Controller
@RequestMapping("/admin")
public class CatalogController {
	 Logger logger = LoggerFactory.getLogger(CatalogController.class);
    @Autowired
    private CatalogService catalogService;

    // Gestion des catégories
    @GetMapping("/categories")
    public String listCategories(Model model) {
        model.addAttribute("categories", catalogService.findAllCategories());
        return "categories";
    }

    @GetMapping("/categories/new")
    public String showNewCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "category-form";
    }

    @PostMapping("/categories/save")
    public String saveCategory(@ModelAttribute("category") Category category, @RequestParam("img") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                // Définir le chemin pour enregistrer l'image
                String fileName = file.getOriginalFilename();
                String uploadDir = "src/main/resources/static/imgs"; // Répertoire où enregistrer l'image
                Path uploadPath = Paths.get(uploadDir);

                // Créer le répertoire s'il n'existe pas
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }

                // Enregistrer le fichier dans le répertoire
                InputStream inputStream = file.getInputStream();
                Path filePath = uploadPath.resolve(fileName);
                Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);

                // Assigner le nom du fichier à l'entité Category
                category.setImage(fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Enregistrer la catégorie
        catalogService.createCategory(category);
        return "redirect:/admin/categories";
    }


    @GetMapping("/categories/edit/{id}")
    public String showEditCategoryForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("category", catalogService.findCategoryById(id).orElseThrow(() -> new RuntimeException("Catégorie introuvable")));
        return "category-form";
    }

    @PostMapping("/categories/update/{id}")
    public String updateCategory(@PathVariable("id") Long id, @ModelAttribute("category") Category category) {
        catalogService.updateCategory(id, category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/categories/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id) {
        catalogService.deleteCategory(id);
        return "redirect:/admin/categories";
    }

    // Gestion des produits
    @GetMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("products", catalogService.findAllProducts());
        return "products";
    }

    @GetMapping("/products/new")
    public String showNewProductForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", catalogService.findAllCategories());
        return "product-form";
    }

    @PostMapping("/products/save")
    public String saveProduct(@ModelAttribute("product") Product product, 
    		@RequestParam("img") MultipartFile file,
    		 @RequestParam("category.id") Long categoryId) {
        
    	// Charger l'objet Category à partir de l'ID
        Category category = catalogService.findCategoryById(categoryId)
                                          .orElseThrow(() -> new RuntimeException("Catégorie introuvable"));

        // Assigner la catégorie au produit
        product.setCategory(category);
        
    	if (!file.isEmpty()) {
            try {
                // Définir le chemin pour enregistrer l'image du produit
                String fileName = file.getOriginalFilename();
                String uploadDir = "src/main/resources/static/imgs"; // Répertoire où enregistrer l'image
                Path uploadPath = Paths.get(uploadDir);

                // Créer le répertoire s'il n'existe pas
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }

                // Enregistrer le fichier dans le répertoire
                InputStream inputStream = file.getInputStream();
                Path filePath = uploadPath.resolve(fileName);
                Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);

                // Assigner le nom du fichier à l'entité Product
                product.setImage(fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Enregistrer le produit
        catalogService.createProduct(product);
        return "redirect:/admin/products";
    }

    @GetMapping("/products/edit/{id}")
    public String showEditProductForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("product", catalogService.findProductById(id).orElseThrow(() -> new RuntimeException("Produit introuvable")));
        model.addAttribute("categories", catalogService.findAllCategories());
        return "product-form";
    }

    @PostMapping("/products/update/{id}")
    public String updateProduct(@PathVariable("id") Long id, @ModelAttribute("product") Product product) {
        catalogService.updateProduct(id, product);
        return "redirect:/admin/products";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        catalogService.deleteProduct(id);
        return "redirect:/admin/products";
    }
}
