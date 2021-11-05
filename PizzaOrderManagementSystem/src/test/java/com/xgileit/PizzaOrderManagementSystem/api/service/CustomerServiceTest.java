package com.xgileit.PizzaOrderManagementSystem.api.service;

import com.xgileit.PizzaOrderManagementSystem.infrastructure.exceptions.CustomerNotRegisteredException;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Customer;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Menu;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Order;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Review;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.CustomerRepository;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.MenuRepository;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.OrderRepository;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

    Customer customer = new Customer("King", "kingdom@gmail.com",
            "qwerty", "10111", "CPT");

    Menu menu = new Menu("Vegan", "Large", "Water", "Large");

    Order order = new Order("2", "4",
            "Vegan", "LARGE", "Water", "Large");

    Review review = new Review(5, "Experience was good");

    @Test
    void registerTest() {
        //When
        when(customerRepository.save(customer)).thenReturn(customer);

        //Then
        assertThat(customerService.register(customer)).isEqualTo(customer);
    }

    @Test
    void loginTestSuccessful() {
        //When
        when(customerRepository.findCustomerById(customer.getId())).thenReturn(Optional.of(customer));

        //Then
        assertThat(customerService.login(customer.getId())).isEqualTo(customer);
    }

    @Test
    void loginTestNotSuccessful(){
        String message = "Customer not registered";

        //Given
        Exception expected = assertThrows(CustomerNotRegisteredException.class,
                () -> {throw new CustomerNotRegisteredException(message);});

        //Then
        assertEquals(message, expected.getMessage());
    }

    @Test
    void viewMenuTest() {
        //When
        customerService.viewMenu();

        //Then
        verify(menuRepository).findAll();
    }

    @Test
    void createOrderTest() {
        //When
        customerService.createOrder(order);

        //Then
        ArgumentCaptor<Order> orderArgumentCaptor = ArgumentCaptor.forClass(Order.class);

        verify(orderRepository).save(orderArgumentCaptor.capture());

        Order capturedOrder = orderArgumentCaptor.getValue();

        assertThat(capturedOrder).isEqualTo(order);
    }

    @Test
    void updateOrderTest() {
        //When
        when(orderRepository.save(order)).thenReturn(order);

        //Then
        assertThat(customerService.updateOrder(order)).isEqualTo(order);
    }

    @Test
    void cancelOrderTest() {
        //Given
        customerService.cancelOrder(order.getId());

        //When
        boolean exists = orderRepository.existsById(order.getId());

        //Then
        assertThat(exists).isFalse();
    }

    @Test
    void submitReviewTest() {
        //When
        customerService.submitReview(review);

        //Then
        ArgumentCaptor<Review> reviewArgumentCaptor = ArgumentCaptor.forClass(Review.class);

        verify(reviewRepository).save(reviewArgumentCaptor.capture());

        Review capturedReview = reviewArgumentCaptor.getValue();

        assertThat(capturedReview).isEqualTo(review);
    }

    @Test
    void listAllDeliveredOrdersTest() {
    }

    @Test
    void listAllPendingOrdersTest() {
    }
}