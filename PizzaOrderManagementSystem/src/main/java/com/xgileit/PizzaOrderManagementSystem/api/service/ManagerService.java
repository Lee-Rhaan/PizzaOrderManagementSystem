package com.xgileit.PizzaOrderManagementSystem.api.service;

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
 *
 */

@Service
@RequiredArgsConstructor
public class ManagerService {

    private final ReviewRepository reviewRepository;
    private final ManagerRepository managerRepository;
    private final MenuRepository menuRepository;
    private final OrderRepository orderRepository;
    private final ChefRepository chefRepository;
    private final DeliveryPersonRepository deliveryPersonRepository;
    private final CustomerRepository customerRepository;

    /**
     *
     * @param id
     * @return
     */
    public Manager login(Long id)
    {
        return managerRepository.findManagerById(id).orElseThrow(() ->
                new ManagerNotFoundException("Manager with id: " + id + " not found"));
    }

    /**
     *
     * @return
     */
    public List<Menu> viewMenu()
    {
        return menuRepository.findAll();
    }

    /**
     *
     * @param menu
     * @return
     */
    public Menu createMenu(Menu menu)
    {
        return menuRepository.save(menu);
    }

    /**
     *
     * @param menu
     * @return
     */
    public Menu updateMenu(Menu menu)
    {
        return menuRepository.save(menu);
    }

    /**
     *
     * @param id
     * @return
     */
    @Transactional
    public String deleteMenu(Long id)
    {
        menuRepository.deleteMenuById(id);
        return "Menu item deleted";
    }

    /**
     *
     * @param order
     * @return
     */
    public Order transferOrderToChef(Order order)
    {
        order.setOrderStatus(TRANSFERRED);
        return orderRepository.save(order);
    }

    /**
     *
     * @param orderId
     * @return
     */
    @Transactional
    public String cancelOrder(Long orderId)
    {
        orderRepository.deleteOrderById(orderId);
        return "Order canceled";
    }

    /**
     *
     * @param order
     * @return
     */
    public Order updateOrder(Order order)
    {
        return orderRepository.save(order);
    }

    /**
     *
     * @return
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
     *
     * @return
     */
    public List<Order> listAllOrders()
    {
        return orderRepository.findAll();
    }

    /**
     *
     * @return
     */
    public List<Review> listAllReviews()
    {
        return reviewRepository.findAll();
    }

    /**
     *
     * @param reviewId
     * @return
     */
    public Review findReviewById(Long reviewId)
    {
        return reviewRepository.findReviewById(reviewId).orElseThrow(() ->
                new ReviewNotFoundException("Review with id: " + reviewId + " not found"));
    }

    /**
     *
     * @param id
     * @return
     */
    public Order findOrderById(Long id)
    {
        return orderRepository.findOrderById(id).orElseThrow(() -> new
                OrderNotFoundException("Order with id: " + id + " not found"));
    }

    /**
     *
     * @param id
     * @return
     */
    public Menu findMenuById(Long id)
    {
        return menuRepository.findMenuById(id).orElseThrow(() -> new
                MenuNotFoundException("Menu with id: " + id + " not found"));
    }

    /**
     *
     * @return
     */
    public List<Chef> listAllChefs()
    {
        return chefRepository.findAll();
    }

    /**
     *
     * @return
     */
    public List<DeliveryPerson> listAllDeliveryPeople()
    {
        return deliveryPersonRepository.findAll();
    }

    /**
     *
     * @return
     */
    public List<Customer> listAllCustomers()
    {
        return customerRepository.findAll();
    }

    /**
     *
     * @return
     */
    public List<Manager> listAllManagers()
    {
        return managerRepository.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    public Customer findCustomer(Long id)
    {
        return customerRepository.findCustomerById(id).orElseThrow(() -> new
                CustomerNotFoundException("Customer with id: " + id + " not found"));
    }

    /**
     *
     * @param id
     * @return
     */
    public Chef findChef(Long id)
    {
        return chefRepository.findChefById(id).orElseThrow(() -> new
                ChefNotFoundException("Customer with id: " + id + " not found"));
    }

    /**
     *
     * @param id
     * @return
     */
    public DeliveryPerson findDeliveryPerson(Long id)
    {
        return deliveryPersonRepository.findDeliveryPersonById(id).orElseThrow(() -> new
                DeliveryPersonNotFoundException("Customer with id: " + id + " not found"));
    }

}
