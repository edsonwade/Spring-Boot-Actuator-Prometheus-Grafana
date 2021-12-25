package com.apllication.app.service;

import com.apllication.app.entities.Order;
import com.apllication.app.repository.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private OrderRepo orderRepo;

    public List<Order> findAll() {
        return orderRepo.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> obj = orderRepo.findById(id);
        return obj.get();
    }
}
