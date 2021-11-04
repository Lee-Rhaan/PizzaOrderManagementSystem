package com.xgileit.PizzaOrderManagementSystem.api.service;

import com.xgileit.PizzaOrderManagementSystem.persistence.repository.CustomerRepository;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.MenuRepository;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.OrderRepository;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private MenuRepository menuRepository;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private ReviewRepository reviewRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    void register() {
    }

    @Test
    void login() {
    }

    @Test
    void viewMenu() {
    }

    @Test
    void createOrder() {
    }

    @Test
    void updateOrder() {
    }

    @Test
    void cancelOrder() {
    }

    @Test
    void submitReview() {
    }

    @Test
    void listAllDeliveredOrders() {
    }

    @Test
    void listAllPendingOrders() {
    }
}