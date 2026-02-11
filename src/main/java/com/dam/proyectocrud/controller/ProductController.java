package com.dam.proyectocrud.controller;

import com.dam.proyectocrud.model.Product;
import com.dam.proyectocrud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // 1. Mostrar la lista de productos (GET /productos)
    @GetMapping
    public String list(Model model) {
        model.addAttribute("productList", productService.getAll());
        return "list"; // Esto busca un archivo llamado "listar.html"
    }

    // 2. Mostrar el formulario para crear un producto (GET /productos/nuevo)
    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("product", new Product());
        return "form"; // Esto busca un archivo llamado "form.html"
    }

    // 3. Guardar el producto enviado desde el formulario (POST /productos/guardar)
    @PostMapping("/save")
    public String save(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/products"; // Al guardar, volvemos a la lista
    }
}