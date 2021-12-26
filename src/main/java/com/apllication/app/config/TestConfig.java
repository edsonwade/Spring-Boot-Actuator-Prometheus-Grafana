package com.apllication.app.config;

import com.apllication.app.entities.Category;
import com.apllication.app.entities.Order;
import com.apllication.app.entities.Product;
import com.apllication.app.entities.User;
import com.apllication.app.entities.enums.OrderStatus;
import com.apllication.app.repository.CategoryRepo;
import com.apllication.app.repository.OrderRepo;
import com.apllication.app.repository.ProductRepo;
import com.apllication.app.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired                     //injection of dependency
    private UserRepo userRepo;
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ProductRepo productRepo;


    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(1, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(2, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(1L, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.PAID);
        Order o2 = new Order(2L, Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.WAITING_PAYMENT);
        Order o3 = new Order(3L, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.WAITING_PAYMENT);
        Order o4 = new Order(4L, Instant.parse("2021-12-22T15:21:22Z"), u1, OrderStatus.DELIVERED);
        Order o5 = new Order(5L, Instant.parse("2021-12-22T15:21:22Z"), u1, OrderStatus.CANCELED);

        Category cat1 = new Category(1L, "Electronics");
        Category cat2 = new Category(2L, "Books");
        Category cat3 = new Category(3L, "Computers");

        Product p1 = new Product(1L, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(2L, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(3L, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(4L, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(5L, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");


        userRepo.saveAll(Arrays.asList(u1, u2));
        orderRepo.saveAll(Arrays.asList(o1, o2, o3, o4, o5));
        categoryRepo.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepo.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

    }
}
