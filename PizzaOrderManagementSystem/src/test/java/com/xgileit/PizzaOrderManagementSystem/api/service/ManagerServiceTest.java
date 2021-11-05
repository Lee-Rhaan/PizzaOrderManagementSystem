package com.xgileit.PizzaOrderManagementSystem.api.service;

import com.xgileit.PizzaOrderManagementSystem.persistence.model.*;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ManagerServiceTest {

    @Mock
    private ManagerRepository managerRepository;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private MenuRepository menuRepository;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private ReviewRepository reviewRepository;

    @Mock
    private ChefRepository chefRepository;

    @Mock
    private DeliveryPersonRepository deliveryPersonRepository;

    @InjectMocks
    private ManagerService managerService;

    Manager manager = new Manager("King", "kingdom@gmail.com",
            "qwerty", "10111", "CPT");

    Customer customer = new Customer("King", "kingdom@gmail.com",
            "qwerty", "10111", "CPT");

    Menu menu = new Menu("Vegan", "Large", "Water", "Large");

    Order order = new Order("2", "4",
            "Vegan", "LARGE", "Water", "Large");

    Review review = new Review(5, "Experience was good");

    Chef chef = new Chef("King", "kingdom@gmail.com",
            "qwerty", "10111", "CPT");

    DeliveryPerson deliveryPerson = new DeliveryPerson("King", "kingdom@gmail.com",
            "qwerty", "10111", "CPT");

    @Test
    void loginTestSuccessful() {
    }

    @Test
    void loginTestNotSuccessful() {
    }

    @Test
    void viewMenuTest() {
    }

    @Test
    void createMenuTest() {
    }

    @Test
    void updateMenuTest() {
    }

    @Test
    void deleteMenuTest() {
    }

    @Test
    void transferOrderToChefTest() {
    }

    @Test
    void cancelOrderTest() {
    }

    @Test
    void updateOrderTest() {
    }

    @Test
    void listAllPendingOrdersTest() {
    }

    @Test
    void listAllOrdersTest() {
    }

    @Test
    void listAllReviewsTest() {
    }

    @Test
    void findReviewByIdTestSuccessful() {
    }

    @Test
    void findReviewByIdTestNotSuccessful() {
    }

    @Test
    void findOrderByIdTestSuccessful() {
    }

    @Test
    void findOrderByIdTestNotSuccessful() {
    }

    @Test
    void findMenuByIdTestSuccessful() {
    }

    @Test
    void findMenuByIdTestNotSuccessful() {
    }

    @Test
    void listAllChefsTest() {
    }

    @Test
    void listAllDeliveryPeopleTest() {
    }

    @Test
    void listAllCustomersTest() {
    }

    @Test
    void listAllManagersTest() {
    }

    @Test
    void findCustomerTestSuccessful() {
    }

    @Test
    void findCustomerTestNotSuccessful() {
    }

    @Test
    void findChefTestSuccessful() {
    }

    @Test
    void findChefTestNotSuccessful() {
    }

    @Test
    void findDeliveryPersonTestSuccessful() {
    }

    @Test
    void findDeliveryPersonTestNotSuccessful() {
    }
}