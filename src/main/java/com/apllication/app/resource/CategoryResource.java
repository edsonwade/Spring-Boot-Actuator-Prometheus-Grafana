package com.apllication.app.resource;

import com.apllication.app.entities.Category;
import com.apllication.app.entities.User;
import com.apllication.app.service.CategoryService;
import com.apllication.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;
import java.util.List;

public class CategoryResource {


    @RestController
    @RequestMapping(value = "/categories")
    public class UserResource {

        @Autowired
        private CategoryService categoryService;

        @GetMapping
        public ResponseEntity<List<Category>> findAll() {
            List<Category> list = categoryService.findAll();
            return ResponseEntity.ok().body(list);
        }

        @GetMapping(value = "/{id}")
        public ResponseEntity<Category> findById(@PathVariable Long id) {
            Category obj = categoryService.findById(id);
            return ResponseEntity.ok().body(obj);
        }

    }
}
