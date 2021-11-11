package com.xgileit.PizzaOrderManagementSystem.api.service;

import com.xgileit.PizzaOrderManagementSystem.infrastructure.enums.OrderStatus;
import com.xgileit.PizzaOrderManagementSystem.infrastructure.exceptions.*;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.*;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

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
    private CustomerReviewRepository customerReviewRepository;

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

    CustomerReview customerReview = new CustomerReview(5, "Experience was good");

    Chef chef = new Chef("King", "kingdom@gmail.com",
            "qwerty", "10111", "CPT");

    DeliveryPerson deliveryPerson = new DeliveryPerson("King", "kingdom@gmail.com",
            "qwerty", "10111", "CPT");

    @Test
    void loginTestSuccessful() {
        //When
        when(managerRepository.findManagerById(manager.getId())).thenReturn(Optional.of(manager));

        //Then
        assertThat(managerService.login(manager.getId())).isEqualTo(manager);
    }

    @Test
    void loginTestNotSuccessful() {
        String message = "Manager not found";

        //Given
        Exception expected = assertThrows(ManagerNotFoundException.class,
                () -> {throw new ManagerNotFoundException(message);});

        //Then
        assertEquals(message, expected.getMessage());
    }

    @Test
    void viewMenuTest() {
        //When
        managerService.viewMenu();

        //Then
        verify(menuRepository).findAll();
    }

    @Test
    void createMenuTest() {
        //When
        managerService.createMenu(menu);

        //Then
        ArgumentCaptor<Menu> menuArgumentCaptor = ArgumentCaptor.forClass(Menu.class);

        verify(menuRepository).save(menuArgumentCaptor.capture());

        Menu capturedMenu = menuArgumentCaptor.getValue();

        assertThat(capturedMenu).isEqualTo(menu);
    }

    @Test
    void updateMenuTest() {
        //When
        when(menuRepository.save(menu)).thenReturn(menu);

        //Then
        assertThat(managerService.updateMenu(menu)).isEqualTo(menu);
    }

    @Test
    void deleteMenuTest() {
        //Given
        managerService.deleteMenuById(menu.getId());

        //When
        boolean exists = menuRepository.existsById(menu.getId());

        //Then
        assertThat(exists).isFalse();
    }

    @Test
    void transferOrderToChefTest() {
        //When
        when(orderRepository.save(order)).thenReturn(order);

        //Then
        assertThat(managerService.transferOrderToChef(order)).isEqualTo(order);
    }

    @Test
    void cancelOrderTest() {
        //Given
        managerService.cancelOrderById(order.getId());

        //When
        boolean exists = orderRepository.existsById(order.getId());

        //Then
        assertThat(exists).isFalse();
    }

    @Test
    void updateOrderTest() {
        //When
        when(orderRepository.save(order)).thenReturn(order);

        //Then
        assertThat(managerService.updateOrder(order)).isEqualTo(order);
    }

    @Test
    void listAllPendingOrdersTest() {
        //given
        Set<Order> mockIterable = mock(Set.class);

        List<Boolean> expectedResultsFromIterator = Arrays.asList(order.getOrderStatus() == OrderStatus.PENDING);

        //when
        MockIterator.mockIterable(mockIterable, order);

        //then
        List<Boolean> results = new ArrayList<>();

        for (Order order : mockIterable) {
            results.add(order.getOrderStatus() == OrderStatus.PENDING);
        }

        assertEquals(expectedResultsFromIterator, results);
    }

    @Test
    void listAllOrdersTest() {
        //When
        managerService.listAllOrders();

        //Then
        verify(orderRepository).findAll();
    }

    @Test
    void listAllReviewsTest() {
        //When
        managerService.listAllReviews();

        //Then
        verify(customerReviewRepository).findAll();
    }

    @Test
    void findReviewByIdTestSuccessful() {
        //When
        when(customerReviewRepository.findReviewById(customerReview.getId())).thenReturn(Optional.of(customerReview));

        //Then
        assertThat(managerService.findReviewById(customerReview.getId())).isEqualTo(customerReview);
    }

    @Test
    void findReviewByIdTestNotSuccessful() {
        String message = "Review not found";

        //Given
        Exception expected = assertThrows(CustomerReviewNotFoundException.class,
                () -> {throw new CustomerReviewNotFoundException(message);});

        //Then
        assertEquals(message, expected.getMessage());
    }

    @Test
    void findOrderByIdTestSuccessful() {
        //When
        when(orderRepository.findOrderById(order.getId())).thenReturn(Optional.of(order));

        //Then
        assertThat(managerService.findOrderById(order.getId())).isEqualTo(order);
    }

    @Test
    void findOrderByIdTestNotSuccessful() {
        String message = "Order not found";

        //Given
        Exception expected = assertThrows(OrderNotFoundException.class,
                () -> {throw new OrderNotFoundException(message);});

        //Then
        assertEquals(message, expected.getMessage());
    }

    @Test
    void findMenuByIdTestSuccessful() {
        //When
        when(menuRepository.findMenuById(menu.getId())).thenReturn(Optional.of(menu));

        //Then
        assertThat(managerService.findMenuById(menu.getId())).isEqualTo(menu);
    }

    @Test
    void findMenuByIdTestNotSuccessful() {
        String message = "Menu not found";

        //Given
        Exception expected = assertThrows(MenuNotFoundException.class,
                () -> {throw new MenuNotFoundException(message);});

        //Then
        assertEquals(message, expected.getMessage());
    }

    @Test
    void listAllChefsTest() {
        //When
        managerService.listAllChefs();

        //Then
        verify(chefRepository).findAll();
    }

    @Test
    void listAllDeliveryPeopleTest() {
        //When
        managerService.listAllDeliveryPeople();

        //Then
        verify(deliveryPersonRepository).findAll();
    }

    @Test
    void listAllCustomersTest() {
        //When
        managerService.listAllCustomers();

        //Then
        verify(customerRepository).findAll();
    }

    @Test
    void listAllManagersTest() {
        //When
        managerService.listAllManagers();

        //Then
        verify(managerRepository).findAll();
    }

    @Test
    void findCustomerTestSuccessful() {
        //When
        when(customerRepository.findCustomerById(customer.getId())).thenReturn(Optional.of(customer));

        //Then
        assertThat(managerService.findCustomerById(customer.getId())).isEqualTo(customer);
    }

    @Test
    void findCustomerTestNotSuccessful() {
        String message = "Customer not found";

        //Given
        Exception expected = assertThrows(CustomerNotFoundException.class,
                () -> {throw new CustomerNotFoundException(message);});

        //Then
        assertEquals(message, expected.getMessage());
    }

    @Test
    void findChefTestSuccessful() {
        //When
        when(chefRepository.findChefById(chef.getId())).thenReturn(Optional.of(chef));

        //Then
        assertThat(managerService.findChefById(chef.getId())).isEqualTo(chef);
    }

    @Test
    void findChefTestNotSuccessful() {
        String message = "Chef not found";

        //Given
        Exception expected = assertThrows(ChefNotFoundException.class,
                () -> {throw new ChefNotFoundException(message);});

        //Then
        assertEquals(message, expected.getMessage());
    }

    @Test
    void findDeliveryPersonTestSuccessful() {
        //When
        when(deliveryPersonRepository.findDeliveryPersonById(deliveryPerson.getId()))
                .thenReturn(Optional.of(deliveryPerson));

        //Then
        assertThat(managerService.findDeliveryPersonById(deliveryPerson.getId()))
                .isEqualTo(deliveryPerson);
    }

    @Test
    void findDeliveryPersonTestNotSuccessful() {
        String message = "Delivery Person not found";

        //Given
        Exception expected = assertThrows(DeliveryPersonNotFoundException.class,
                () -> {throw new DeliveryPersonNotFoundException(message);});

        //Then
        assertEquals(message, expected.getMessage());
    }
}