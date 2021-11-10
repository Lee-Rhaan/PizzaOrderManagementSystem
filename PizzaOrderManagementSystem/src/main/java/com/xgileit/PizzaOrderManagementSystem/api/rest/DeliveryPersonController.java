package com.xgileit.PizzaOrderManagementSystem.api.rest;

import com.xgileit.PizzaOrderManagementSystem.api.service.DeliveryPersonService;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.DeliveryPerson;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This is the Controller class. It specifies the endpoints you'd have to use to get access
 * to this server.
 *
 * The @RequestMapping annotation determines what type of requests this class handles. So in this case
 * if you want access to this class -> you need to access it through the base request("/api/v1/deliveries")
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/deliveries")
public class DeliveryPersonController {

    /**
     * Here I am injecting the DeliveryPersonService in this class with the @RequiredArgsConstructor
     * in order to have access to all it's functionalities.
     */
    private final DeliveryPersonService deliveryPersonService;

    /**
     * How to access this method: "/api/v1/deliveries/login/{deliveryPersonId}"
     * This delivery person don't need to register in order to get access to this server.
     * They can just log in by providing their unique id.
     *
     * @param deliveryPersonId Long
     * @return Logged in delivery person if request were successful
     */
    @GetMapping("/login/{deliveryPersonId}")
    public ResponseEntity<DeliveryPerson> login(@PathVariable("deliveryPersonId") Long deliveryPersonId)
    {
        DeliveryPerson deliveryPerson = deliveryPersonService.login(deliveryPersonId);
        return new ResponseEntity<>(deliveryPerson, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/deliveries/orders/deliver"
     * Sets the status of the order to "Delivered" if it exists in the database, and
     * then replaces the old order with this updated version.
     *
     * @param order object
     * @return updated order if request were successful
     */
    @PutMapping("/orders/deliver")
    public ResponseEntity<Order> deliverOrder(@RequestBody Order order)
    {
        Order deliveredOrder = deliveryPersonService.deliverOrder(order);
        return new ResponseEntity<>(deliveredOrder, HttpStatus.OK);
    }
}
