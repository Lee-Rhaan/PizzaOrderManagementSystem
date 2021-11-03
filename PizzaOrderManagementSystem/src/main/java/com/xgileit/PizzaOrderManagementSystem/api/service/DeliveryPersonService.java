package com.xgileit.PizzaOrderManagementSystem.api.service;

import com.xgileit.PizzaOrderManagementSystem.infrastructure.exceptions.DeliveryPersonNotFoundException;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.DeliveryPerson;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Order;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.DeliveryPersonRepository;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.xgileit.PizzaOrderManagementSystem.infrastructure.enums.OrderStatus.DELIVERED;

@Service
@RequiredArgsConstructor
public class DeliveryPersonService {

    private final DeliveryPersonRepository deliveryPersonRepository;
    private final OrderRepository orderRepository;

    public DeliveryPerson login(Long id)
    {
        return deliveryPersonRepository.findDeliveryPersonById(id).orElseThrow(() ->
                new DeliveryPersonNotFoundException("Delivery Person with id: " + id + " not found"));
    }

    public Order deliverOrder(Order order)
    {
        order.setOrderStatus(DELIVERED);
        return orderRepository.save(order);
    }
}
