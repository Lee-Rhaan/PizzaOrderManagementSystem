package com.xgileit.PizzaOrderManagementSystem.api.rest;

import com.xgileit.PizzaOrderManagementSystem.api.service.ManagerService;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.*;
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
 * if you want access to this class -> you need to access it through the base request("/api/v1/admin")
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/admin")
public class ManagerController {

    /**
     * Here I am injecting the ManagerService in this class with the @RequiredArgsConstructor
     * in order to have access to all it's functionalities.
     */
    private final ManagerService managerService;

    /**
     * How to access this method: "/api/v1/admin/login/{id}"
     * This manager don't need to register in order to get access to this server.
     * They can just log in by providing their unique id.
     *
     * @param id Long
     * @return Logged in manager if request were successful
     */
    @GetMapping("/login/{id}")
    public ResponseEntity<Manager> login(@PathVariable("id") Long id)
    {
        Manager manager = managerService.login(id);
        return new ResponseEntity<>(manager, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/admin/menu"
     * @return list of products on Menu
     */
    @GetMapping("/menu")
    public ResponseEntity<List<Menu>> viewMenu()
    {
        List<Menu> menu = managerService.viewMenu();
        return new ResponseEntity<>(menu, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/admin/create/menu"
     * Menu gets created and saved in database
     *
     * @param menu object
     * @return saved menu if request were successful
     */
    @PostMapping("/create/menu")
    public ResponseEntity<Menu> createMenu(@RequestBody Menu menu)
    {
        Menu newMenu = managerService.createMenu(menu);
        return new ResponseEntity<>(newMenu, HttpStatus.CREATED);
    }

    /**
     * How to access this method: "/api/v1/admin/update/menu"
     * This method will replace the old menu object with this newly updated menu object
     * if the menu object exists in the database.
     *
     * @param menu object
     * @return updated menu if request were successful
     */
    @PutMapping("/update/menu")
    public ResponseEntity<Menu> updateMenu(@RequestBody Menu menu)
    {
        Menu updatedMenu = managerService.updateMenu(menu);
        return new ResponseEntity<>(updatedMenu, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/admin/delete/menu/{id}"
     * This method will delete a menu object from the database by using it's id as
     * a reference.
     *
     * @param id Long
     * @return String response if request were successful
     */
    @DeleteMapping("/delete/menu/{id}")
    public ResponseEntity<String> deleteMenu(@PathVariable("id") Long id)
    {
        String response = managerService.deleteMenu(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/admin/transfer/order"
     * Sets the status of the order to "Transferred" if it exists in the database, and
     * then replaces the old order with this updated version.
     *
     * @param order object
     * @return updated order if request were successful
     */
    @PutMapping("/transfer/order")
    public ResponseEntity<Order> transferOrderToChef(@RequestBody Order order)
    {
        Order transferredOrder = managerService.transferOrderToChef(order);
        return new ResponseEntity<>(transferredOrder, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/admin/cancel/order/{id}"
     * This method will delete an order object from the database by using it's id as
     * a reference.
     *
     * @param id Long
     * @return String response if request were successful
     */
    @DeleteMapping("/cancel/order/{id}")
    public ResponseEntity<String> cancelOrder(@PathVariable("id") Long id)
    {
        String response = managerService.cancelOrder(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/admin/update/order"
     * This method will replace the old order object with this newly updated order object
     * if the order object exists in the database.
     *
     * @param order object
     * @return updated order if request were successful
     */
    @PutMapping("/update/order")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order)
    {
        Order updatedOrder = managerService.updateOrder(order);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/admin/all/pending/orders"
     * @return List of all orders stored in the database with pending status
     */
    @GetMapping("/all/pending/orders")
    public ResponseEntity<List<Order>> listAllPendingOrders()
    {
        List<Order> pendingOrders = managerService.listAllPendingOrders();
        return new ResponseEntity<>(pendingOrders, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/admin/all/orders"
     * @return list of all orders stored in the database
     */
    @GetMapping("/all/orders")
    public ResponseEntity<List<Order>> listAllOrders()
    {
        List<Order> allOrders = managerService.listAllOrders();
        return new ResponseEntity<>(allOrders, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/admin/all/reviews"
     * @return List of all customer reviews
     */
    @GetMapping("/all/reviews")
    public ResponseEntity<List<Review>> listAllReviews()
    {
        List<Review> allReviews = managerService.listAllReviews();
        return new ResponseEntity<>(allReviews, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/admin/find/review/{id}"
     * This method will find a review by it's id in the database.
     *
     * @param id Long
     * @return review object if review exists in database or Error message if review
     *         with specified id does not exist in database
     */
    @GetMapping("/find/review/{id}")
    public ResponseEntity<Review> findReview(@PathVariable("id") Long id)
    {
        Review review = managerService.findReviewById(id);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/admin/find/order/{id}"
     * This method will find an order by it's id in the database.
     *
     * @param id Long
     * @return order object if order exists in database or Error message if order
     *         with specified id does not exist in database
     */
    @GetMapping("/find/order/{id}")
    public ResponseEntity<Order> findOrder(@PathVariable("id") Long id)
    {
        Order order = managerService.findOrderById(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/admin/find/menu/{id}"
     * This method will find a menu by it's id in the database.
     *
     * @param id Long
     * @return menu object if menu exists in database or Error message if menu
     *         with specified id does not exist in database
     */
    @GetMapping("/find/menu/{id}")
    public ResponseEntity<Menu> findMenu(@PathVariable("id") Long id)
    {
        Menu menu = managerService.findMenuById(id);
        return new ResponseEntity<>(menu, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/admin/all/chef"
     * @return List of all chefs stored in database
     */
    @GetMapping("/all/chef")
    public ResponseEntity<List<Chef>> listAllChefs()
    {
        List<Chef> chefs = managerService.listAllChefs();
        return new ResponseEntity<>(chefs, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/admin/all/deliveryPeople"
     * @return List of all Delivery persons stored in database
     */
    @GetMapping("/all/deliveryPeople")
    public ResponseEntity<List<DeliveryPerson>> listAllDeliveryPeople()
    {
        List<DeliveryPerson> deliveryPeople = managerService.listAllDeliveryPeople();
        return new ResponseEntity<>(deliveryPeople, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/admin/all/customer"
     * @return List of all customers stored in database.
     */
    @GetMapping("/all/customer")
    public ResponseEntity<List<Customer>> listAllCustomers()
    {
        List<Customer> customers = managerService.listAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/admin/all/manager"
     * @return List of all managers stored in database.
     */
    @GetMapping("/all/manager")
    public ResponseEntity<List<Manager>> listAllManagers()
    {
        List<Manager> managers = managerService.listAllManagers();
        return new ResponseEntity<>(managers, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/admin/find/customer/{id}"
     * This method will find a customer by it's id in the database.
     *
     * @param id Long
     * @return customer object if customer exists in database or Error message if customer
     *         with specified id does not exist in database
     */
    @GetMapping("/find/customer/{id}")
    public ResponseEntity<Customer> findCustomer(@PathVariable("id") Long id)
    {
        Customer customer = managerService.findCustomer(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/admin/find/chef/{id}"
     * This method will find a chef by it's id in the database.
     *
     * @param id Long
     * @return chef object if chef exists in database or Error message if chef
     *         with specified id does not exist in database
     */
    @GetMapping("/find/chef/{id}")
    public ResponseEntity<Chef> findChef(@PathVariable("id") Long id)
    {
        Chef chef = managerService.findChef(id);
        return new ResponseEntity<>(chef, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/admin/find/deliveryPerson/{id}"
     * This method will find a delivery person by it's id in the database.
     *
     * @param id Long
     * @return delivery person object if delivery person exists in database or Error message if
     *         delivery person with specified id does not exist in database
     */
    @GetMapping("/find/deliveryPerson/{id}")
    public ResponseEntity<DeliveryPerson> findDeliveryPerson(@PathVariable("id") Long id)
    {
        DeliveryPerson deliveryPerson = managerService.findDeliveryPerson(id);
        return new ResponseEntity<>(deliveryPerson, HttpStatus.OK);
    }

}
