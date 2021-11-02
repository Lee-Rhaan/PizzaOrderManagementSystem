package com.xgileit.PizzaOrderManagementSystem.api.service;

import com.xgileit.PizzaOrderManagementSystem.persistence.repository.DeliveryPersonRepository;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChefService {

    private final OrderRepository orderRepository;
    private final DeliveryPersonRepository deliveryPersonRepository;
}
