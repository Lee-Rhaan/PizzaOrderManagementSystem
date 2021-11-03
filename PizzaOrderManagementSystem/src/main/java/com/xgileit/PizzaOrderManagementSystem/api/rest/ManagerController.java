package com.xgileit.PizzaOrderManagementSystem.api.rest;

import com.xgileit.PizzaOrderManagementSystem.api.service.ManagerService;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.*;
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
@RequestMapping("/api/v1/admin")
public class ManagerController {

    private final ManagerService managerService;

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/login/{id}")
    public ResponseEntity<Manager> login(@PathVariable("id") Long id)
    {
        Manager manager = managerService.login(id);
        return new ResponseEntity<>(manager, HttpStatus.OK);
    }

    /**
     *
     * @return
     */
    @GetMapping("/menu")
    public ResponseEntity<List<Menu>> viewMenu()
    {
        List<Menu> menu = managerService.viewMenu();
        return new ResponseEntity<>(menu, HttpStatus.OK);
    }

    /**
     *
     * @param menu
     * @return
     */
    @PostMapping("/create/menu")
    public ResponseEntity<Menu> createMenu(@RequestBody Menu menu)
    {
        Menu newMenu = managerService.createMenu(menu);
        return new ResponseEntity<>(newMenu, HttpStatus.CREATED);
    }

    /**
     *
     * @param menu
     * @return
     */
    @PutMapping("/update/menu")
    public ResponseEntity<Menu> updateMenu(@RequestBody Menu menu)
    {
        Menu updatedMenu = managerService.updateMenu(menu);
        return new ResponseEntity<>(updatedMenu, HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/menu/{id}")
    public ResponseEntity<String> deleteMenu(@PathVariable("id") Long id)
    {
        String response = managerService.deleteMenu(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     *
     * @param order
     * @return
     */
    @PutMapping("/transfer/order")
    public ResponseEntity<Order> transferOrderToChef(@RequestBody Order order)
    {
        Order transferredOrder = managerService.transferOrderToChef(order);
        return new ResponseEntity<>(transferredOrder, HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/cancel/order/{id}")
    public ResponseEntity<String> cancelOrder(@PathVariable("id") Long id)
    {
        String response = managerService.cancelOrder(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     *
     * @param order
     * @return
     */
    @PutMapping("/update/order")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order)
    {
        Order updatedOrder = managerService.updateOrder(order);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }

    /**
     *
     * @return
     */
    @GetMapping("/all/pending/orders")
    public ResponseEntity<List<Order>> listAllPendingOrders()
    {
        List<Order> pendingOrders = managerService.listAllPendingOrders();
        return new ResponseEntity<>(pendingOrders, HttpStatus.OK);
    }

    /**
     *
     * @return
     */
    @GetMapping("/all/orders")
    public ResponseEntity<List<Order>> listAllOrders()
    {
        List<Order> allOrders = managerService.listAllOrders();
        return new ResponseEntity<>(allOrders, HttpStatus.OK);
    }

    /**
     *
     * @return
     */
    @GetMapping("/all/reviews")
    public ResponseEntity<List<Review>> listAllReviews()
    {
        List<Review> allReviews = managerService.listAllReviews();
        return new ResponseEntity<>(allReviews, HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/find/review/{id}")
    public ResponseEntity<Review> findReview(@PathVariable("id") Long id)
    {
        Review review = managerService.findReviewById(id);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/find/order/{id}")
    public ResponseEntity<Order> findOrder(@PathVariable("id") Long id)
    {
        Order order = managerService.findOrderById(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/find/menu/{id}")
    public ResponseEntity<Menu> findMenu(@PathVariable("id") Long id)
    {
        Menu menu = managerService.findMenuById(id);
        return new ResponseEntity<>(menu, HttpStatus.OK);
    }

    /**
     *
     * @return
     */
    @GetMapping("/all/chef")
    public ResponseEntity<List<Chef>> listAllChefs()
    {
        List<Chef> chefs = managerService.listAllChefs();
        return new ResponseEntity<>(chefs, HttpStatus.OK);
    }

    /**
     *
     * @return
     */
    @GetMapping("/all/deliveryPeople")
    public ResponseEntity<List<DeliveryPerson>> listAllDeliveryPeople()
    {
        List<DeliveryPerson> deliveryPeople = managerService.listAllDeliveryPeople();
        return new ResponseEntity<>(deliveryPeople, HttpStatus.OK);
    }

    /**
     *
     * @return
     */
    @GetMapping("/all/customer")
    public ResponseEntity<List<Customer>> listAllCustomers()
    {
        List<Customer> customers = managerService.listAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    /**
     *
     * @return
     */
    @GetMapping("/all/manager")
    public ResponseEntity<List<Manager>> listAllManagers()
    {
        List<Manager> managers = managerService.listAllManagers();
        return new ResponseEntity<>(managers, HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/find/customer/{id}")
    public ResponseEntity<Customer> findCustomer(@PathVariable("id") Long id)
    {
        Customer customer = managerService.findCustomer(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/find/chef/{id}")
    public ResponseEntity<Chef> findChef(@PathVariable("id") Long id)
    {
        Chef chef = managerService.findChef(id);
        return new ResponseEntity<>(chef, HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/find/deliveryPerson/{id}")
    public ResponseEntity<DeliveryPerson> findDeliveryPerson(@PathVariable("id") Long id)
    {
        DeliveryPerson deliveryPerson = managerService.findDeliveryPerson(id);
        return new ResponseEntity<>(deliveryPerson, HttpStatus.OK);
    }

}
