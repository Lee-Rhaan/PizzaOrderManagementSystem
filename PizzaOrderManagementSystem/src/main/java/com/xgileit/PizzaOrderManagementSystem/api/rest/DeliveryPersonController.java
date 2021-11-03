package com.xgileit.PizzaOrderManagementSystem.api.rest;

import com.xgileit.PizzaOrderManagementSystem.api.service.DeliveryPersonService;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.DeliveryPerson;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/delivery")
public class DeliveryPersonController {

    private final DeliveryPersonService deliveryPersonService;

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/login/{id}")
    public ResponseEntity<DeliveryPerson> login(@PathVariable("id") Long id)
    {
        DeliveryPerson deliveryPerson = deliveryPersonService.login(id);
        return new ResponseEntity<>(deliveryPerson, HttpStatus.OK);
    }

    /**
     *
     * @param order
     * @return
     */
    @PutMapping("/deliver/order")
    public ResponseEntity<Order> deliverOrder(@RequestBody Order order)
    {
        Order deliveredOrder = deliveryPersonService.deliverOrder(order);
        return new ResponseEntity<>(deliveredOrder, HttpStatus.OK);
    }
}
