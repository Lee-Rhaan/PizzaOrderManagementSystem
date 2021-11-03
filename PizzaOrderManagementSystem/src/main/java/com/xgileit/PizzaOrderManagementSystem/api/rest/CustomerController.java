package com.xgileit.PizzaOrderManagementSystem.api.rest;

import com.xgileit.PizzaOrderManagementSystem.api.service.CustomerService;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Customer;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Menu;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Order;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    /**
     *
     * @param customer
     * @return
     */
    @PostMapping("/register")
    public ResponseEntity<Customer> register(@RequestBody Customer customer)
    {
        Customer newCustomer = customerService.register(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/login/{id}")
    public ResponseEntity<Customer> login(@PathVariable("id") Long id)
    {
        Customer customer = customerService.login(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    /**
     *
     * @return
     */
    @GetMapping("/menu")
    public ResponseEntity<List<Menu>> viewMenu()
    {
        List<Menu> menu = customerService.viewMenu();
        return new ResponseEntity<>(menu, HttpStatus.OK);
    }

    /**
     *
     * @param order
     * @return
     */
    @PostMapping("/create/order")
    public ResponseEntity<Order> createOrder(@RequestBody Order order)
    {
        Order newOrder = customerService.createOrder(order);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

    /**
     *
     * @param order
     * @return
     */
    @PutMapping("/update/order")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order)
    {
        Order updatedOrder = customerService.updateOrder(order);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/cancel/order")
    public ResponseEntity<String> cancelOrder(@PathVariable("id") Long id)
    {
        String response = customerService.cancelOrder(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     *
     * @param review
     * @return
     */
    @PostMapping("/submit/review")
    public ResponseEntity<Review> submitReview(@RequestBody Review review)
    {
        Review newReview = customerService.submitReview(review);
        return new ResponseEntity<>(newReview, HttpStatus.CREATED);
    }

    /**
     *
     * @return
     */
    @GetMapping("/all/delivered/orders")
    public ResponseEntity<List<Order>> listAllDeliveredOrders()
    {
        List<Order> deliveredOrders = customerService.listAllDeliveredOrders();
        return new ResponseEntity<>(deliveredOrders, HttpStatus.OK);
    }

    /**
     *
     * @return
     */
    @GetMapping("/all/pending/orders")
    public ResponseEntity<List<Order>> listAllPendingOrders()
    {
        List<Order> pendingOrders = customerService.listAllPendingOrders();
        return new ResponseEntity<>(pendingOrders, HttpStatus.OK);
    }
}
