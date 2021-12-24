package com.apllication.app.service;

import com.apllication.app.entities.User;
import com.apllication.app.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    /**
     * @return list of  all users
     */
    public List<User> findAll() {
        return userRepo.findAll();
    }

    /**
     * find the user by id
     *
     * @param id
     */
    public User findById(Long id) {
        Optional<User> obj = userRepo.findById(id);
        return obj.get();
    }

}
