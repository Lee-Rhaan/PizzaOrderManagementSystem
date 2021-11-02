package com.xgileit.PizzaOrderManagementSystem.api.service;

import com.xgileit.PizzaOrderManagementSystem.infrastructure.exceptions.ManagerNotFoundException;
import com.xgileit.PizzaOrderManagementSystem.infrastructure.exceptions.ReviewNotFoundException;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Manager;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Menu;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Order;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Review;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.ManagerRepository;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.MenuRepository;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.OrderRepository;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.xgileit.PizzaOrderManagementSystem.infrastructure.enums.OrderStatus.PENDING;
import static com.xgileit.PizzaOrderManagementSystem.infrastructure.enums.OrderStatus.TRANSFERRED;

@Service
@RequiredArgsConstructor
public class ManagerService {

    private final ReviewRepository reviewRepository;
    private final ManagerRepository managerRepository;
    private final MenuRepository menuRepository;
    private final OrderRepository orderRepository;

    public Manager login(String email, String password)
    {
        return managerRepository.findManagerByEmailAndPassword(email, password).orElseThrow(() ->
                new ManagerNotFoundException("Manager with email: " + email + " and password: " + password + " not found"));
    }

    public List<Menu> viewMenu()
    {
        return menuRepository.findAll();
    }

    public Menu createMenu(Menu menu)
    {
        return menuRepository.save(menu);
    }

    public Menu updateMenu(Menu menu)
    {
        return menuRepository.save(menu);
    }

    @Transactional
    public String deleteMenuItem(Long id)
    {
        menuRepository.deleteMenuItem(id);
        return "Menu item deleted";
    }

    public Order transferOrderToChef(Order order)
    {
        order.setOrderStatus(TRANSFERRED);
        return orderRepository.save(order);
    }

    public String cancelOrder(Long orderId)
    {
        orderRepository.deleteOrderById(orderId);
        return "Order canceled";
    }

    public Order updateOrder(Order order)
    {
        return orderRepository.save(order);
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

    public List<Order> listAllOrders()
    {
        return orderRepository.findAll();
    }

    public List<Review> listAllReviews()
    {
        return reviewRepository.findAll();
    }

    public Review findReviewById(Long reviewId)
    {
        return reviewRepository.findReviewById(reviewId).orElseThrow(() ->
                new ReviewNotFoundException("Review with id: " + reviewId + " not found"));
    }

}
