package com.xgileit.PizzaOrderManagementSystem.api.service;

import com.xgileit.PizzaOrderManagementSystem.infrastructure.enums.OrderStatus;
import com.xgileit.PizzaOrderManagementSystem.infrastructure.exceptions.CustomerNotRegisteredException;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Customer;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Menu;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Order;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Review;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.CustomerRepository;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.MenuRepository;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.OrderRepository;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.xgileit.PizzaOrderManagementSystem.infrastructure.enums.OrderStatus.DELIVERED;
import static com.xgileit.PizzaOrderManagementSystem.infrastructure.enums.OrderStatus.PENDING;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final MenuRepository menuRepository;
    private final OrderRepository orderRepository;
    private final ReviewRepository reviewRepository;

    public Customer register(Customer customer)
    {
        customer.setCustomerCode(UUID.randomUUID().toString());
        return customerRepository.save(customer);
    }

    public Customer login(Long id)
    {
        return customerRepository.findCustomerById(id).orElseThrow(() ->
                new CustomerNotRegisteredException("Customer with id: " + id + " not registered"));
    }

    public List<Menu> viewMenu()
    {
        return menuRepository.findAll();
    }

    public Order createOrder(Order order)
    {
        order.setOrderStatus(OrderStatus.PENDING);
        return orderRepository.save(order);
    }

    public Order updateOrder(Order order)
    {
        return orderRepository.save(order);
    }

    @Transactional
    public String cancelOrder(Long orderId)
    {
        orderRepository.deleteOrderById(orderId);
        return "Order canceled";
    }

    public Review submitReview(Review review)
    {
        return reviewRepository.save(review);
    }

    public List<Order> listOfDeliveredOrders()
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

    public List<Order> listOfPendingOrders()
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
