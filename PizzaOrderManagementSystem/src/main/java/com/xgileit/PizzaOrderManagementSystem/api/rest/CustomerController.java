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
 * This is the Controller class. It specifies the endpoints you'd have to use to get access
 * to this server.
 *
 * The @RequestMapping annotation determines what type of requests this class handles. So in this case
 * if you want access to this class -> you need to access it through the base request("/api/v1/customer")
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    /**
     * Here I am injecting the CustomerService in this class with the @RequiredArgsConstructor
     * in order to have access to all it's functionalities.
     */
    private final CustomerService customerService;

    /**
     * How to access this method: "/api/v1/customer/register"
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
     * How to access this method: "/api/v1/customer/login/{id}"
     * Allows the customer to log in by providing their unique id.
     * (Their id gets provided when they register on the server)
     *
     * @param id Long
     * @return logged in customer if request were successful
     */
    @GetMapping("/login/{id}")
    public ResponseEntity<Customer> login(@PathVariable("id") Long id)
    {
        Customer customer = customerService.login(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/customer/menu"
     * @return List of products on menu
     */
    @GetMapping("/menu")
    public ResponseEntity<List<Menu>> viewMenu()
    {
        List<Menu> menu = customerService.viewMenu();
        return new ResponseEntity<>(menu, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/customer/create/order"
     * Order gets created and stored in database
     *
     * @param order object
     * @return saved order if request were successful
     */
    @PostMapping("/create/order")
    public ResponseEntity<Order> createOrder(@RequestBody Order order)
    {
        Order newOrder = customerService.createOrder(order);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

    /**
     * How to access this method: "/api/v1/customer/update/order"
     * This method will replace the old order object with this newly updated order object
     * if the order object exists in the database.
     *
     * @param order object
     * @return updated order if request were successful
     */
    @PutMapping("/update/order")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order)
    {
        Order updatedOrder = customerService.updateOrder(order);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/customer/cancel/order"
     * This method will delete an order object from the database by using it's id as
     * a reference.
     *
     * @param id Long
     * @return String response if request were successful
     */
    @DeleteMapping("/cancel/order")
    public ResponseEntity<String> cancelOrder(@PathVariable("id") Long id)
    {
        String response = customerService.cancelOrder(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/customer/submit/review"
     * Review gets created and saved in database
     *
     * @param review object
     * @return saved review if request were successful
     */
    @PostMapping("/submit/review")
    public ResponseEntity<Review> submitReview(@RequestBody Review review)
    {
        Review newReview = customerService.submitReview(review);
        return new ResponseEntity<>(newReview, HttpStatus.CREATED);
    }

    /**
     * How to access this method: "/api/v1/customer/all/delivered/orders"
     * @return List of all orders with delivered status stored in database
     */
    @GetMapping("/all/delivered/orders")
    public ResponseEntity<List<Order>> listAllDeliveredOrders()
    {
        List<Order> deliveredOrders = customerService.listAllDeliveredOrders();
        return new ResponseEntity<>(deliveredOrders, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/customer/all/pending/orders"
     * @return List of all order with pending status stored in database
     */
    @GetMapping("/all/pending/orders")
    public ResponseEntity<List<Order>> listAllPendingOrders()
    {
        List<Order> pendingOrders = customerService.listAllPendingOrders();
        return new ResponseEntity<>(pendingOrders, HttpStatus.OK);
    }
}
