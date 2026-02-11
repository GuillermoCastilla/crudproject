package com.dam.proyectocrud.service;

import com.dam.proyectocrud.model.Product;
import com.dam.proyectocrud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Optional<Product> getById(Long id){
        return productRepository.findById(id);
    }

    public void save(Product product) {
        productRepository.save(product);
    }
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
