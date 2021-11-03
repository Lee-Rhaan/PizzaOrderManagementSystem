package com.xgileit.PizzaOrderManagementSystem.persistence.repository;

import com.xgileit.PizzaOrderManagementSystem.persistence.model.DeliveryPerson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeliveryPersonRepository extends JpaRepository<DeliveryPerson, Long> {
    Optional<DeliveryPerson> findDeliveryPersonById(Long id);
}
