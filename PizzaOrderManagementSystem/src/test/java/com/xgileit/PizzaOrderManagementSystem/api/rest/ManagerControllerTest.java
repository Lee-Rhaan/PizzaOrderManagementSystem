package com.xgileit.PizzaOrderManagementSystem.api.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xgileit.PizzaOrderManagementSystem.api.service.ManagerService;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.*;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.ChefRepository;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.CustomerRepository;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.DeliveryPersonRepository;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.ManagerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(ManagerController.class)
class ManagerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static ObjectMapper objectMapper = new ObjectMapper();

    @MockBean
    ManagerService managerService;

    @MockBean
    ManagerRepository managerRepository;

    @MockBean
    ChefRepository chefRepository;

    @MockBean
    CustomerRepository customerRepository;

    @MockBean
    DeliveryPersonRepository deliveryPersonRepository;

    Manager firstManager = new Manager("King", "kingdom@gmail.com",
            "qwerty", "10111", "CPT");

    Customer customer = new Customer("King", "kingdom@gmail.com",
            "qwerty", "10111", "CPT");

    Menu menu = new Menu("Vegan", "Large", "Water", "Large");

    Order order = new Order("2", "4",
            "Vegan", "LARGE", "Water", "Large");

    CustomerReview customerReview = new CustomerReview(5, "Experience was good");

    Chef chef = new Chef("King", "kingdom@gmail.com",
            "qwerty", "10111", "CPT");

    DeliveryPerson deliveryPerson = new DeliveryPerson("King", "kingdom@gmail.com",
            "qwerty", "10111", "CPT");

    @Test
    void loginTest() {
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
    void deleteMenuByIdTest() {
    }

    @Test
    void transferOrderToChefTest() {
    }

    @Test
    void cancelOrderByIdTest() {
    }

    @Test
    void updateOrderTest() {
    }

    @Test
    void listAllPendingOrdersTest() {
    }

    @Test
    void listAllOrdersTest() throws Exception {
        List<Order> listOrders = new ArrayList<>();
        listOrders.add(order);

        Mockito.when(managerService.listAllOrders()).thenReturn(listOrders);

        MvcResult mvcResult = mockMvc.perform(get("http://localhost:8080/api/v1/admins/orders"))
                .andExpect(status().isOk()).andReturn();

        String actualJsonResponse = mvcResult.getResponse().getContentAsString();
        System.out.println(actualJsonResponse);

        String expectedJsonResponse = objectMapper.writeValueAsString(listOrders);

        assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);
    }

    @Test
    void listAllReviewsTest() {
    }

    @Test
    void findReviewByIdTest() {
    }

    @Test
    void findOrderByIdTest() {
    }

    @Test
    void findMenuByIdTest() {
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
    void findCustomerByIdTest() {
    }

    @Test
    void findChefByIdTest() {
    }

    @Test
    void findDeliveryPersonByIdTest() {
    }
}