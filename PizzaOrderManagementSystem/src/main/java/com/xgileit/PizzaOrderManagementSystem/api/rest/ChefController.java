package com.xgileit.PizzaOrderManagementSystem.api.rest;

import com.xgileit.PizzaOrderManagementSystem.api.service.ChefService;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Chef;
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
@RequestMapping("/api/v1/chef")
public class ChefController {

    private final ChefService chefService;

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/login/{id}")
    public ResponseEntity<Chef> login(@PathVariable("id") Long id)
    {
        Chef chef = chefService.login(id);
        return new ResponseEntity<>(chef, HttpStatus.OK);
    }

    /**
     *
     * @param order
     * @return
     */
    @PutMapping("/prepare/order")
    public ResponseEntity<Order> prepareOrder(@RequestBody Order order)
    {
        Order preparedOrder = chefService.prepareOrder(order);
        return new ResponseEntity<>(preparedOrder, HttpStatus.OK);
    }

}
