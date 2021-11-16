package com.xgileit.PizzaOrderManagementSystem.api.rest;

import com.xgileit.PizzaOrderManagementSystem.api.service.CustomerService;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Customer;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Menu;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Order;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.CustomerReview;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This is the Controller class. It specifies the endpoints you'd have to use to get access
 * to this server.
 *
 * The @RequestMapping annotation determines what type of requests this class handles. So in this case
 * if you want access to this class -> you need to access it through the base request("/api/v1/customers")
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    /**
     * Here I am injecting the CustomerService in this class with the @RequiredArgsConstructor
     * in order to have access to all it's functionalities.
     */
    private final CustomerService customerService;

    /**
     * How to access this method: "/api/v1/customers/register"
     * This method registers and adds a new customer to the database.
     *
     * @param customer object
     * @return registered customer if request were successful
     */
    @PostMapping("/register")
    public ResponseEntity<Customer> register(@RequestBody Customer customer)
    {
        Customer newCustomer = customerService.register(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    /**
     * How to access this method: "/api/v1/customers/login/{customerId}"
     * Allows the customer to log in by providing their unique id.
     * (Their id gets provided when they register on the server)
     *
     * @param customerId Long
     * @return logged in customer if request were successful
     */
    @GetMapping("/login/{customerId}")
    public ResponseEntity<Customer> login(@PathVariable("customerId") Long customerId)
    {
        Customer customer = customerService.login(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/customers/menu"
     * @return List of products on menu
     */
    @GetMapping("/menu")
    public ResponseEntity<List<Menu>> viewMenu()
    {
        List<Menu> menu = customerService.viewMenu();
        return new ResponseEntity<>(menu, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/customers/orders"
     * Order gets created and stored in database
     *
     * @param order object
     * @return saved order if request were successful
     */
    @PostMapping("/orders")
    public ResponseEntity<Order> createOrder(@RequestBody Order order)
    {
        Order newOrder = customerService.createOrder(order);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

    /**
     * How to access this method: "/api/v1/customers/orders"
     * This method will replace the old order object with this newly updated order object
     * if the order object exists in the database.
     *
     * @param order object
     * @return updated order if request were successful
     */
    @PutMapping("/orders")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order)
    {
        Order updatedOrder = customerService.updateOrder(order);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/customers/orders/{orderId}"
     * This method will delete an order object from the database by using it's id as
     * a reference.
     *
     * @param orderId Long
     * @return String response if request were successful
     */
    @DeleteMapping("/orders/{orderId}")
    public ResponseEntity<String> cancelOrderById(@PathVariable("orderId") Long orderId)
    {
        String response = customerService.cancelOrderById(orderId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/customers/reviews"
     * Review gets created and saved in database
     *
     * @param customerReview object
     * @return saved review if request were successful
     */
    @PostMapping("/reviews")
    public ResponseEntity<CustomerReview> submitReview(@RequestBody CustomerReview customerReview)
    {
        CustomerReview newCustomerReview = customerService.submitReview(customerReview);
        return new ResponseEntity<>(newCustomerReview, HttpStatus.CREATED);
    }

    /**
     * How to access this method: "/api/v1/customers/orders/delivered"
     * @return List of all orders with delivered status stored in database
     */
    @GetMapping("/orders/delivered")
    public ResponseEntity<List<Order>> listAllDeliveredOrders()
    {
        List<Order> deliveredOrders = customerService.listAllDeliveredOrders();
        return new ResponseEntity<>(deliveredOrders, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/customers/orders/pending"
     * @return List of all order with pending status stored in database
     */
    @GetMapping("/orders/pending")
    public ResponseEntity<List<Order>> listAllPendingOrders()
    {
        List<Order> pendingOrders = customerService.listAllPendingOrders();
        return new ResponseEntity<>(pendingOrders, HttpStatus.OK);
    }
}
