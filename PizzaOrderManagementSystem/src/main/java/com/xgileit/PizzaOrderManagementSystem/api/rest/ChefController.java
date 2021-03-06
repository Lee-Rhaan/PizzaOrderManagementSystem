package com.xgileit.PizzaOrderManagementSystem.api.rest;

import com.xgileit.PizzaOrderManagementSystem.api.service.ChefService;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Chef;
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
 * if you want access to this class -> you need to access it through the base request("/api/v1/chefs")
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/chefs")
public class ChefController {

    /**
     * Here I am injecting the ChefService in this class with the @RequiredArgsConstructor
     * in order to have access to all it's functionalities.
     */
    private final ChefService chefService;

    /**
     * How to access this method: "/api/v1/chefs/login/{chefId}"
     * This chef don't need to register in order to get access to this server.
     * They can just log in by providing their unique id.
     *
     * @param chefId Long
     * @return logged in chef if the request was successful
     */
    @GetMapping("/login/{chefId}")
    public ResponseEntity<Chef> login(@PathVariable("chefId") Long chefId)
    {
        Chef chef = chefService.login(chefId);
        return new ResponseEntity<>(chef, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/chefs/orders/prepare"
     * Sets the status of the order to "Prepared" if it exists in the database, and
     * then replaces the old order with this updated version.
     *
     * @param order object
     * @return updated order if request were successful
     */
    @PutMapping("/orders/prepare")
    public ResponseEntity<Order> prepareOrder(@RequestBody Order order)
    {
        Order preparedOrder = chefService.prepareOrder(order);
        return new ResponseEntity<>(preparedOrder, HttpStatus.OK);
    }

}
