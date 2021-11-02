package com.xgileit.PizzaOrderManagementSystem.api.service;

import com.xgileit.PizzaOrderManagementSystem.persistence.repository.ChefRepository;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.MenuRepository;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManagerService {

    private final MenuRepository menuRepository;
    private final ChefRepository chefRepository;
    private final OrderRepository orderRepository;
}
