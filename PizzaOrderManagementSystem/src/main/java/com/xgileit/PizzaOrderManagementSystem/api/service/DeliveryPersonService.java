package com.xgileit.PizzaOrderManagementSystem.api.service;

import com.xgileit.PizzaOrderManagementSystem.infrastructure.enums.Status;
import com.xgileit.PizzaOrderManagementSystem.infrastructure.exceptions.DeliveryPersonNotFoundException;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.DeliveryPerson;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Order;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.DeliveryPersonRepository;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.xgileit.PizzaOrderManagementSystem.infrastructure.enums.OrderStatus.DELIVERED;

/**
 * This is the Service class. Here I am implementing all the business logic for the delivery person.
 */

@Service
@RequiredArgsConstructor
public class DeliveryPersonService {

    /**
     * Here I am injecting these two repositories with the @RequiredArgsConstructor in order to
     * have access to all it's functionalities.
     */
    private final DeliveryPersonRepository deliveryPersonRepository;
    private final OrderRepository orderRepository;

    /**
     * If a delivery person with the deliveryPersonId being passed as an argument
     * exists in the database, he/she gets logged in.
     * If not, an exception gets thrown.
     *
     * @param deliveryPersonId Long
     * @return Logged in delivery person or exception
     */
    public DeliveryPerson login(Long deliveryPersonId)
    {
        DeliveryPerson deliveryPerson = deliveryPersonRepository.findDeliveryPersonById(deliveryPersonId).orElseThrow(() ->
                new DeliveryPersonNotFoundException("Delivery Person with id: " + deliveryPersonId + " not found"));

        deliveryPerson.setStatus(Status.LOGGED_IN);

        return deliveryPerson;
    }

    /**
     * Sets the status of the order to "Delivered" if it exists in the database, and
     * then replaces the old order with this updated version.
     *
     * @param order object
     * @return updated order
     */
    public Order deliverOrder(Order order)
    {
        order.setOrderStatus(DELIVERED);
        return orderRepository.save(order);
    }
}
