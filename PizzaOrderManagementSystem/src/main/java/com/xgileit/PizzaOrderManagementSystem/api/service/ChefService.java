package com.xgileit.PizzaOrderManagementSystem.api.service;

import com.xgileit.PizzaOrderManagementSystem.infrastructure.enums.Status;
import com.xgileit.PizzaOrderManagementSystem.infrastructure.exceptions.ChefNotFoundException;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Chef;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Order;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.ChefRepository;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.xgileit.PizzaOrderManagementSystem.infrastructure.enums.OrderStatus.PREPARED;

/**
 * This is the Service class. Here I am implementing all the business logic for the chef.
 */

@Service
@RequiredArgsConstructor
public class ChefService {

    /**
     * Here I am injecting these two repositories with the @RequiredArgsConstructor in order to
     * have access to all it's functionalities.
     */
    private final ChefRepository chefRepository;
    private final OrderRepository orderRepository;

    /**
     * If a chef with the id being passed as an argument exists in the database, he/she gets
     * logged in.
     * If not, an exception gets thrown.
     *
     * @param id Long
     * @return Logged in chef or exception
     */
    public Chef login(Long id)
    {
        Chef chef = chefRepository.findChefById(id).orElseThrow(() ->
                new ChefNotFoundException("Chef with id: " + id + " not found"));

        chef.setStatus(Status.LOGGED_IN);

        return chef;
    }

    /**
     * Sets the status of the order to "Prepared" if it exists in the database, and
     * then replaces the old order with this updated version.
     *
     * @param order object
     * @return updated order
     */
    public Order prepareOrder(Order order)
    {
        order.setOrderStatus(PREPARED);
        return orderRepository.save(order);
    }

}
