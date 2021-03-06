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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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

    Manager manager = new Manager("King", "kingdom@gmail.com",
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
    void viewMenuTest() throws Exception {
        List<Menu> listMenu = new ArrayList<>();
        listMenu.add(menu);

        Mockito.when(managerService.viewMenu()).thenReturn(listMenu);

        MvcResult mvcResult = mockMvc.perform(get("http://localhost:8080/api/v1/admins/menu"))
                .andExpect(status().isOk()).andReturn();

        String actualJsonResponse = mvcResult.getResponse().getContentAsString();
        System.out.println(actualJsonResponse);

        String expectedJsonResponse = objectMapper.writeValueAsString(listMenu);

        assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);
    }

    @Test
    void createMenuTest() throws Exception {
        Menu savedMenu = new Menu("Vegan", "Large", "Water", "Large");
        savedMenu.setId(1l);

        Mockito.when(managerService.createMenu(menu)).thenReturn(savedMenu);

        menu.setId(savedMenu.getId());

        mockMvc.perform(post("http://localhost:8080/api/v1/admins/menu")
                .contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                        .content(objectMapper.writeValueAsString(menu)))
                .andExpect(status().isCreated()).andExpect(content().string(objectMapper.writeValueAsString(menu)));
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
    void listAllReviewsTest() throws Exception {
        List<CustomerReview> listCustomerReviews = new ArrayList<>();
        listCustomerReviews.add(customerReview);

        Mockito.when(managerService.listAllReviews()).thenReturn(listCustomerReviews);

        MvcResult mvcResult = mockMvc.perform(get("http://localhost:8080/api/v1/admins/reviews"))
                .andExpect(status().isOk()).andReturn();

        String actualJsonResponse = mvcResult.getResponse().getContentAsString();
        System.out.println(actualJsonResponse);

        String expectedJsonResponse = objectMapper.writeValueAsString(listCustomerReviews);

        assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);
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
    void listAllChefsTest() throws Exception {
        List<Chef> listChefs = new ArrayList<>();
        listChefs.add(chef);

        Mockito.when(managerService.listAllChefs()).thenReturn(listChefs);

        MvcResult mvcResult = mockMvc.perform(get("http://localhost:8080/api/v1/admins/chefs"))
                .andExpect(status().isOk()).andReturn();

        String actualJsonResponse = mvcResult.getResponse().getContentAsString();
        System.out.println(actualJsonResponse);

        String expectedJsonResponse = objectMapper.writeValueAsString(listChefs);

        assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);
    }

    @Test
    void listAllDeliveryPeopleTest() throws Exception {
        List<DeliveryPerson> listDeliveryPeople = new ArrayList<>();
        listDeliveryPeople.add(deliveryPerson);

        Mockito.when(managerService.listAllDeliveryPeople()).thenReturn(listDeliveryPeople);

        MvcResult mvcResult = mockMvc.perform(get("http://localhost:8080/api/v1/admins/deliveryPeople"))
                .andExpect(status().isOk()).andReturn();

        String actualJsonResponse = mvcResult.getResponse().getContentAsString();
        System.out.println(actualJsonResponse);

        String expectedJsonResponse = objectMapper.writeValueAsString(listDeliveryPeople);

        assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);
    }

    @Test
    void listAllCustomersTest() throws Exception {
        List<Customer> listCustomers = new ArrayList<>();
        listCustomers.add(customer);

        Mockito.when(managerService.listAllCustomers()).thenReturn(listCustomers);

        MvcResult mvcResult = mockMvc.perform(get("http://localhost:8080/api/v1/admins/customers"))
                .andExpect(status().isOk()).andReturn();

        String actualJsonResponse = mvcResult.getResponse().getContentAsString();
        System.out.println(actualJsonResponse);

        String expectedJsonResponse = objectMapper.writeValueAsString(listCustomers);

        assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);
    }

    @Test
    void listAllManagersTest() throws Exception {
        List<Manager> listManagers = new ArrayList<>();
        listManagers.add(manager);

        Mockito.when(managerService.listAllManagers()).thenReturn(listManagers);

        MvcResult mvcResult = mockMvc.perform(get("http://localhost:8080/api/v1/admins/managers"))
                .andExpect(status().isOk()).andReturn();

        String actualJsonResponse = mvcResult.getResponse().getContentAsString();
        System.out.println(actualJsonResponse);

        String expectedJsonResponse = objectMapper.writeValueAsString(listManagers);

        assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);
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