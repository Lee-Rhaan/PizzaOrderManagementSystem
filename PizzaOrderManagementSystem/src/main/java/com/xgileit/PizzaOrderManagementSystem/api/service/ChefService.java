package com.xgileit.PizzaOrderManagementSystem.api.service;

import com.xgileit.PizzaOrderManagementSystem.infrastructure.exceptions.ChefNotFoundException;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Chef;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Order;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.ChefRepository;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.xgileit.PizzaOrderManagementSystem.infrastructure.enums.OrderStatus.PREPARED;

/**
 *
 */

@Service
@RequiredArgsConstructor
public class ChefService {

    private final ChefRepository chefRepository;
    private final OrderRepository orderRepository;

    /**
     *
     * @param id
     * @return
     */
    public Chef login(Long id)
    {
        return chefRepository.findChefById(id).orElseThrow(() ->
                new ChefNotFoundException("Chef with id: " + id + " not found"));
    }

    /**
     *
     * @param order
     * @return
     */
    public Order prepareOrder(Order order)
    {
        order.setOrderStatus(PREPARED);
        return orderRepository.save(order);
    }

}
