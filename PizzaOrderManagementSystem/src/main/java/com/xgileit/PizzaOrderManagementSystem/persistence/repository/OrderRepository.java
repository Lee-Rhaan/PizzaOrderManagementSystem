package com.xgileit.PizzaOrderManagementSystem.persistence.repository;

import com.xgileit.PizzaOrderManagementSystem.persistence.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * I'm extending this interface with "JpaRepository", to get access to all it's CRUD
 * functionalities.
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

    /**
     * These are custom abstract methods I am going to be implementing in my service class.
     * The names of these methods are going to be read like queries by Spring.
     */
    void deleteOrderById(Long id);

    //setting it to optional, because this method may or may not return a value.
    Optional<Order> findOrderById(Long id);
}
