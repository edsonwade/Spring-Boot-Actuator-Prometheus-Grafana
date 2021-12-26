package com.apllication.app.service;

import com.apllication.app.entities.Category;
import com.apllication.app.entities.Product;
import com.apllication.app.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> findAll() {
        return productRepo.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> obj = productRepo.findById(id);
        return obj.get();
    }
}
