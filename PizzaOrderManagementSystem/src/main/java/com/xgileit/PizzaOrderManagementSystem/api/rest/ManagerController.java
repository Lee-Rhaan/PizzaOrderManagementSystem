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
 * if you want access to this class -> you need to access it through the base request("/api/v1/admins")
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/admins")
public class ManagerController {

    /**
     * Here I am injecting the ManagerService in this class with the @RequiredArgsConstructor
     * in order to have access to all it's functionalities.
     */
    private final ManagerService managerService;

    /**
     * How to access this method: "/api/v1/admins/login/{managerId}"
     * This manager don't need to register in order to get access to this server.
     * They can just log in by providing their unique id.
     *
     * @param managerId Long
     * @return Logged in manager if request were successful
     */
    @GetMapping("/login/{managerId}")
    public ResponseEntity<Manager> login(@PathVariable("managerId") Long managerId)
    {
        Manager manager = managerService.login(managerId);
        return new ResponseEntity<>(manager, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/admins/menu"
     * @return list of products on Menu
     */
    @GetMapping("/menu")
    public ResponseEntity<List<Menu>> viewMenu()
    {
        List<Menu> menu = managerService.viewMenu();
        return new ResponseEntity<>(menu, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/admins/menu/create"
     * Menu gets created and saved in database
     *
     * @param menu object
     * @return saved menu if request were successful
     */
    @PostMapping("/menu/create")
    public ResponseEntity<Menu> createMenu(@RequestBody Menu menu)
    {
        Menu newMenu = managerService.createMenu(menu);
        return new ResponseEntity<>(newMenu, HttpStatus.CREATED);
    }

    /**
     * How to access this method: "/api/v1/admins/menu/update"
     * This method will replace the old menu object with this newly updated menu object
     * if the menu object exists in the database.
     *
     * @param menu object
     * @return updated menu if request were successful
     */
    @PutMapping("/menu/update")
    public ResponseEntity<Menu> updateMenu(@RequestBody Menu menu)
    {
        Menu updatedMenu = managerService.updateMenu(menu);
        return new ResponseEntity<>(updatedMenu, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/admins/menu/delete/{menuId}"
     * This method will delete a menu object from the database by using it's id as
     * a reference.
     *
     * @param menuId Long
     * @return String response if request were successful
     */
    @DeleteMapping("/menu/delete/{menuId}")
    public ResponseEntity<String> deleteMenuById(@PathVariable("menuId") Long menuId)
    {
        String response = managerService.deleteMenuById(menuId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/admins/orders/transfer"
     * Sets the status of the order to "Transferred" if it exists in the database, and
     * then replaces the old order with this updated version.
     *
     * @param order object
     * @return updated order if request were successful
     */
    @PutMapping("/orders/transfer")
    public ResponseEntity<Order> transferOrderToChef(@RequestBody Order order)
    {
        Order transferredOrder = managerService.transferOrderToChef(order);
        return new ResponseEntity<>(transferredOrder, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/admins/orders/cancel/{orderId}"
     * This method will delete an order object from the database by using it's orderId as
     * a reference.
     *
     * @param orderId Long
     * @return String response if request were successful
     */
    @DeleteMapping("/orders/cancel/{orderId}")
    public ResponseEntity<String> cancelOrderById(@PathVariable("orderId") Long orderId)
    {
        String response = managerService.cancelOrderById(orderId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/admins/orders/update"
     * This method will replace the old order object with this newly updated order object
     * if the order object exists in the database.
     *
     * @param order object
     * @return updated order if request were successful
     */
    @PutMapping("/orders/update")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order)
    {
        Order updatedOrder = managerService.updateOrder(order);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/admins/orders/pending"
     * @return List of all orders stored in the database with pending status
     */
    @GetMapping("/orders/pending")
    public ResponseEntity<List<Order>> listAllPendingOrders()
    {
        List<Order> pendingOrders = managerService.listAllPendingOrders();
        return new ResponseEntity<>(pendingOrders, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/admins/orders"
     * @return list of all orders stored in the database
     */
    @GetMapping("/orders")
    public ResponseEntity<List<Order>> listAllOrders()
    {
        List<Order> allOrders = managerService.listAllOrders();
        return new ResponseEntity<>(allOrders, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/admins/reviews"
     * @return List of all customer reviews
     */
    @GetMapping("/reviews")
    public ResponseEntity<List<CustomerReview>> listAllReviews()
    {
        List<CustomerReview> allCustomerReviews = managerService.listAllReviews();
        return new ResponseEntity<>(allCustomerReviews, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/admins/reviews/review/{reviewId}"
     * This method will find a review by it's reviewId in the database.
     *
     * @param reviewId Long
     * @return review object if review exists in database or Error message if review
     *         with specified id does not exist in database
     */
    @GetMapping("/reviews/review/{reviewId}")
    public ResponseEntity<CustomerReview> findReviewById(@PathVariable("reviewId") Long reviewId)
    {
        CustomerReview customerReview = managerService.findReviewById(reviewId);
        return new ResponseEntity<>(customerReview, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/admins/orders/order/{orderId}"
     * This method will find an order by it's orderId in the database.
     *
     * @param orderId Long
     * @return order object if order exists in database or Error message if order
     *         with specified id does not exist in database
     */
    @GetMapping("/orders/order/{orderId}")
    public ResponseEntity<Order> findOrderById(@PathVariable("orderId") Long orderId)
    {
        Order order = managerService.findOrderById(orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/admins/menu/find/{menuId}"
     * This method will find a menu by it's menuId in the database.
     *
     * @param menuId Long
     * @return menu object if menu exists in database or Error message if menu
     *         with specified id does not exist in database
     */
    @GetMapping("/menu/find/{menuId}")
    public ResponseEntity<Menu> findMenuById(@PathVariable("menuId") Long menuId)
    {
        Menu menu = managerService.findMenuById(menuId);
        return new ResponseEntity<>(menu, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/admins/chefs"
     * @return List of all chefs stored in database
     */
    @GetMapping("/chefs")
    public ResponseEntity<List<Chef>> listAllChefs()
    {
        List<Chef> chefs = managerService.listAllChefs();
        return new ResponseEntity<>(chefs, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/admins/deliveryPeople"
     * @return List of all Delivery persons stored in database
     */
    @GetMapping("/deliveryPeople")
    public ResponseEntity<List<DeliveryPerson>> listAllDeliveryPeople()
    {
        List<DeliveryPerson> deliveryPeople = managerService.listAllDeliveryPeople();
        return new ResponseEntity<>(deliveryPeople, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/admins/customers"
     * @return List of all customers stored in database.
     */
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> listAllCustomers()
    {
        List<Customer> customers = managerService.listAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/admins/managers"
     * @return List of all managers stored in database.
     */
    @GetMapping("/managers")
    public ResponseEntity<List<Manager>> listAllManagers()
    {
        List<Manager> managers = managerService.listAllManagers();
        return new ResponseEntity<>(managers, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/admins/customers/customer/{customerId}"
     * This method will find a customer by it's customerId in the database.
     *
     * @param customerId Long
     * @return customer object if customer exists in database or Error message if customer
     *         with specified id does not exist in database
     */
    @GetMapping("/customers/customer/{customerId}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable("customerId") Long customerId)
    {
        Customer customer = managerService.findCustomerById(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/admins/chefs/chef/{chefId}"
     * This method will find a chef by it's chefId in the database.
     *
     * @param chefId Long
     * @return chef object if chef exists in database or Error message if chef
     *         with specified id does not exist in database
     */
    @GetMapping("/chefs/chef/{chefId}")
    public ResponseEntity<Chef> findChefById(@PathVariable("chefId") Long chefId)
    {
        Chef chef = managerService.findChefById(chefId);
        return new ResponseEntity<>(chef, HttpStatus.OK);
    }

    /**
     * How to access this method: "/api/v1/admins/deliveryPerson/find/{deliveryPersonId}"
     * This method will find a delivery person by it's deliveryPersonId in the database.
     *
     * @param deliveryPersonId Long
     * @return delivery person object if delivery person exists in database or Error message if
     *         delivery person with specified id does not exist in database
     */
    @GetMapping("/deliveryPerson/find/{deliveryPersonId}")
    public ResponseEntity<DeliveryPerson> findDeliveryPersonById(@PathVariable("deliveryPersonId") Long deliveryPersonId)
    {
        DeliveryPerson deliveryPerson = managerService.findDeliveryPersonById(deliveryPersonId);
        return new ResponseEntity<>(deliveryPerson, HttpStatus.OK);
    }

}
