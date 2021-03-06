package com.xgileit.PizzaOrderManagementSystem.api.service;

import com.xgileit.PizzaOrderManagementSystem.infrastructure.enums.ActiveStatus;
import com.xgileit.PizzaOrderManagementSystem.infrastructure.exceptions.*;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.*;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.xgileit.PizzaOrderManagementSystem.infrastructure.enums.OrderStatus.PENDING;
import static com.xgileit.PizzaOrderManagementSystem.infrastructure.enums.OrderStatus.TRANSFERRED;

/**
 * This is the Service class. Here I am implementing all the business logic for the manager.
 */

@Service
@RequiredArgsConstructor
public class ManagerService {

    /**
     * Here I am injecting all these repositories with the @RequiredArgsConstructor in order to
     * have access to all it's functionalities.
     */
    private final CustomerReviewRepository customerReviewRepository;
    private final ManagerRepository managerRepository;
    private final MenuRepository menuRepository;
    private final OrderRepository orderRepository;
    private final ChefRepository chefRepository;
    private final DeliveryPersonRepository deliveryPersonRepository;
    private final CustomerRepository customerRepository;

    /**
     * If a manager with the managerId being passed as an argument exists in the database, he/she gets
     * logged in.
     * If not, an exception gets thrown.
     *
     * @param managerId Long
     * @return Logged in manager or exception
     */
    public Manager login(Long managerId)
    {
        Manager manager = managerRepository.findManagerById(managerId).orElseThrow(() ->
                new ManagerNotFoundException("Manager with id: " + managerId + " not found"));

        manager.setActiveStatus(ActiveStatus.LOGGED_IN);

        return manager;
    }

    /**
     * @return List of products on menu
     */
    public List<Menu> viewMenu()
    {
        return menuRepository.findAll();
    }

    /**
     * Menu gets created and saved in the database
     *
     * @param menu object
     * @return saved menu
     */
    public Menu createMenu(Menu menu)
    {
        return menuRepository.save(menu);
    }

    /**
     * Updates the properties of an existing menu in the database.
     *
     * @param menu object
     * @return updated menu
     */
    public Menu updateMenu(Menu menu)
    {
        return menuRepository.save(menu);
    }

    /**
     * Checks if a menu with a matching menuId exists in the database.
     * If it exists, the menu will be removed.
     *
     * @param menuId Long
     * @return String response
     */
    @Transactional
    public String deleteMenuById(Long menuId)
    {
        menuRepository.deleteMenuById(menuId);
        return "Menu item deleted";
    }

    /**
     * Sets the status of the order to "Transferred" if it exists in the database, and
     * then replaces the old order with this updated version.
     *
     * @param order object
     * @return updated order
     */
    public Order transferOrderToChef(Order order)
    {
        order.setOrderStatus(TRANSFERRED);
        return orderRepository.save(order);
    }

    /**
     * This method will delete an order object from the database by using it's orderId as
     * a reference.
     *
     * @param orderId Long
     * @return String response
     */
    @Transactional
    public String cancelOrderById(Long orderId)
    {
        orderRepository.deleteOrderById(orderId);
        return "Order canceled";
    }

    /**
     * Updates the properties of an existing order in the database.
     *
     * @param order object
     * @return updated order
     */
    public Order updateOrder(Order order)
    {
        return orderRepository.save(order);
    }

    /**
     * @return List of all orders stored in the database with pending status
     */
    public List<Order> listAllPendingOrders()
    {
        List<Order> pendingOrders = new ArrayList<>();

        for(Order order : orderRepository.findAll())
        {
            if(order.getOrderStatus() == PENDING)
            {
                pendingOrders.add(order);
            }
        }

        return pendingOrders;
    }

    /**
     * @return List of all orders stored in the database
     */
    public List<Order> listAllOrders()
    {
        return orderRepository.findAll();
    }

    /**
     *
     * @return List of all reviews stored in the database
     */
    public List<CustomerReview> listAllReviews()
    {
        return customerReviewRepository.findAll();
    }

    /**
     * This method will find a review by it's reviewId in the database.
     *
     * @param reviewId Long
     * @return review object if review exists in database or Error message if review
     *         with specified id does not exist in database
     */
    public CustomerReview findReviewById(Long reviewId)
    {
        return customerReviewRepository.findReviewById(reviewId).orElseThrow(() ->
                new CustomerReviewNotFoundException("Review with id: " + reviewId + " not found"));
    }

    /**
     * This method will find an order by it's orderId in the database.
     *
     * @param orderId Long
     * @return order object if order exists in database or Error message if order
     *        with specified id does not exist in database
     */
    public Order findOrderById(Long orderId)
    {
        return orderRepository.findOrderById(orderId).orElseThrow(() -> new
                OrderNotFoundException("Order with id: " + orderId + " not found"));
    }

    /**
     * This method will find a menu by it's menuId in the database.
     *
     * @param menuId Long
     * @return menu object if menu exists in database or Error message if menu
     *         with specified id does not exist in database
     */
    public Menu findMenuById(Long menuId)
    {
        return menuRepository.findMenuById(menuId).orElseThrow(() -> new
                MenuNotFoundException("Menu with id: " + menuId + " not found"));
    }

    /**
     * @return List of all chefs stored in database
     */
    public List<Chef> listAllChefs()
    {
        return chefRepository.findAll();
    }

    /**
     * @return List of all delivery people stored in database
     */
    public List<DeliveryPerson> listAllDeliveryPeople()
    {
        return deliveryPersonRepository.findAll();
    }

    /**
     * @return List of all customers stored in database
     */
    public List<Customer> listAllCustomers()
    {
        return customerRepository.findAll();
    }

    /**
     * @return List of all managers stored in database
     */
    public List<Manager> listAllManagers()
    {
        return managerRepository.findAll();
    }

    /**
     * This method will find a customer by it's customerId in the database.
     *
     * @param customerId Long
     * @return customer object if customer exists in database or Error message if customer
     *         with specified id does not exist in database
     */
    public Customer findCustomerById(Long customerId)
    {
        return customerRepository.findCustomerById(customerId).orElseThrow(() -> new
                CustomerNotFoundException("Customer with id: " + customerId + " not found"));
    }

    /**
     * This method will find a chef by it's chefId in the database.
     *
     * @param chefId Long
     * @return chef object if chef exists in database or Error message if chef
     *        with specified id does not exist in database
     */
    public Chef findChefById(Long chefId)
    {
        return chefRepository.findChefById(chefId).orElseThrow(() -> new
                ChefNotFoundException("Customer with id: " + chefId + " not found"));
    }

    /**
     * This method will find a delivery person by it's deliveryPersonId in the database.
     *
     * @param deliveryPersonId Long
     * @return delivery person object if delivery person exists in database or Error message if
     *         delivery person with specified id does not exist in database
     */
    public DeliveryPerson findDeliveryPersonById(Long deliveryPersonId)
    {
        return deliveryPersonRepository.findDeliveryPersonById(deliveryPersonId).orElseThrow(() -> new
                DeliveryPersonNotFoundException("Customer with id: " + deliveryPersonId + " not found"));
    }

}
