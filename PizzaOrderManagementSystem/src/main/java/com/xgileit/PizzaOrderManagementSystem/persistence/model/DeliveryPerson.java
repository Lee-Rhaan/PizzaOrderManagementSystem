package com.xgileit.PizzaOrderManagementSystem.persistence.model;

import com.xgileit.PizzaOrderManagementSystem.infrastructure.enums.ActiveStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * This is the DeliveryPerson Entity class which will be mapped to the database.
 * This entity will store all the delivery people in this Pizza Order System.
 */
@Table(name = "delivery_person")
@Data
@NoArgsConstructor
@Entity
public class DeliveryPerson implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long deliveryPersonId;
    private String username;
    private String email;
    private String password;
    private String phone;
    private String address;
    @Column(name = "employee_code")
    private String employeeCode = UUID.randomUUID().toString();
    @Column(name = "active_status")
    private ActiveStatus activeStatus;

    public DeliveryPerson(String username, String email, String password, String phone, String address)
    {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }
}