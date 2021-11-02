package com.xgileit.PizzaOrderManagementSystem.api.service;

import com.xgileit.PizzaOrderManagementSystem.infrastructure.exceptions.ChefNotFoundException;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Chef;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Order;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.ChefRepository;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.xgileit.PizzaOrderManagementSystem.infrastructure.enums.OrderStatus.PREPARED;

@Service
@RequiredArgsConstructor
public class ChefService {

    private final ChefRepository chefRepository;
    private final OrderRepository orderRepository;

    public Chef login(String email, String password)
    {
        return chefRepository.findChefByEmailAndPassword(email, password).orElseThrow(() ->
                new ChefNotFoundException("Chef with email: " + email + " and password: " + password + " not found"));
    }

    public Order prepareOrder(Order order)
    {
        order.setOrderStatus(PREPARED);
        return orderRepository.save(order);
    }

}
