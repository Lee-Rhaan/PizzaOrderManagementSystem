package com.xgileit.PizzaOrderManagementSystem.api.service;

import com.xgileit.PizzaOrderManagementSystem.infrastructure.enums.OrderStatus;
import com.xgileit.PizzaOrderManagementSystem.infrastructure.enums.ActiveStatus;
import com.xgileit.PizzaOrderManagementSystem.infrastructure.exceptions.CustomerNotRegisteredException;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Customer;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Menu;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Order;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.CustomerReview;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.CustomerRepository;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.MenuRepository;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.OrderRepository;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.CustomerReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.xgileit.PizzaOrderManagementSystem.infrastructure.enums.OrderStatus.DELIVERED;
import static com.xgileit.PizzaOrderManagementSystem.infrastructure.enums.OrderStatus.PENDING;

/**
 * This is the Service class. Here I am implementing all the business logic for the customer.
 */

@Service
@RequiredArgsConstructor
public class CustomerService {

    /**
     * Here I am injecting all these repositories with the @RequiredArgsConstructor in order to
     * have access to all it's functionalities.
     */
    private final CustomerRepository customerRepository;
    private final MenuRepository menuRepository;
    private final OrderRepository orderRepository;
    private final CustomerReviewRepository customerReviewRepository;

    /**
     * This method registers and adds a new customer to the database.
     *
     * @param customer object
     * @return registered customer if request were successful
     */
    public Customer register(Customer customer)
    {
        customer.setCustomerCode(UUID.randomUUID().toString());
        return customerRepository.save(customer);
    }

    /**
     * If a customer with the customerId being passed as an argument exists in the database, he/she gets
     * logged in.
     * If not, an exception gets thrown.
     *
     * @param customerId Long
     * @return Logged in customer or exception
     */
    public Customer login(Long customerId)
    {
        Customer customer = customerRepository.findCustomerById(customerId).orElseThrow(() ->
                new CustomerNotRegisteredException("Customer with id: " + customerId + " not registered"));

        customer.setActiveStatus(ActiveStatus.LOGGED_IN);

        return customer;
    }

    /**
     * @return List of products on menu
     */
    public List<Menu> viewMenu()
    {
        return menuRepository.findAll();
    }

    /**
     * Order gets created and stored in database
     *
     * @param order object
     * @return saved order
     */
    public Order createOrder(Order order)
    {
        order.setOrderStatus(OrderStatus.PENDING);
        return orderRepository.save(order);
    }

    /**
     * This method will replace the old order object with this newly updated order object
     * if the order object exists in the database.
     *
     * @param order object
     * @return updated order
     */
    public Order updateOrder(Order order)
    {
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
     * Review gets created and saved in database
     *
     * @param customerReview object
     * @return saved review
     */
    public CustomerReview submitReview(CustomerReview customerReview)
    {
        return customerReviewRepository.save(customerReview);
    }

    /**
     * @return List of all orders with delivered status stored in database
     */
    public List<Order> listAllDeliveredOrders()
    {
        List<Order> deliveredOrders = new ArrayList<>();

        for(Order order : orderRepository.findAll())
        {
            if(order.getOrderStatus() == DELIVERED)
            {
                deliveredOrders.add(order);
            }
        }

        return deliveredOrders;
    }

    /**
     * @return List of all orders with pending status stored in database
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

}
