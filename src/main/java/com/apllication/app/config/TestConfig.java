package com.apllication.app.config;

import com.apllication.app.entities.User;
import com.apllication.app.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired                     //injection of dependency
    private UserRepo userRepo;


    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(1, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(2, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepo.saveAll(Arrays.asList(u1, u2));

    }
}
