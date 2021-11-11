package com.xgileit.PizzaOrderManagementSystem.persistence.repository;

import com.xgileit.PizzaOrderManagementSystem.persistence.model.Chef;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * I'm extending this interface with "JpaRepository", to get access to all it's CRUD
 * functionalities.
 */
public interface ChefRepository extends JpaRepository<Chef, Long> {

    /**
     * This is a custom abstract method I am going to be implementing in my service class.
     * The name of this method is going to be read like a query by Spring.
     */

    //setting it to optional, because this method may or may not return a value.
    Optional<Chef> findChefById(Long chefId);
}
