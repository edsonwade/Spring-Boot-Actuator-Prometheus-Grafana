package com.apllication.app.service;

import com.apllication.app.entities.Category;
import com.apllication.app.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> obj = categoryRepo.findById(id);
        return obj.get();
    }
}
