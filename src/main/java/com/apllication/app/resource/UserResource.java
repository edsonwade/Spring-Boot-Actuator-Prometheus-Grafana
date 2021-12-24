package com.apllication.app.resource;

import com.apllication.app.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @GetMapping

    public ResponseEntity <User> findAll() {
        User user = new User(1L, "Vanilson muhongo", "vanilson@example.com", "999999", "12345");
        List<User> list = new ArrayList<>();
        return ResponseEntity.ok().body(user);
    }
}
