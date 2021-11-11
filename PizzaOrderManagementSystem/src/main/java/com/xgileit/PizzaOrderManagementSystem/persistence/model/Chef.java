package com.xgileit.PizzaOrderManagementSystem.persistence.model;

import com.xgileit.PizzaOrderManagementSystem.infrastructure.enums.ActiveStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * This is the Chef Entity class which will be mapped to the database.
 * This entity will store all the chefs in this Pizza Order System.
 */
@Data
@NoArgsConstructor
@Entity
public class Chef implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long chefId;
    private String username;
    private String email;
    private String password;
    private String phone;
    private String address;
    @Column(name = "employee_code")
    private String employeeCode = UUID.randomUUID().toString();
    @Column(name = "active_status")
    private ActiveStatus activeStatus;

    public Chef(String username, String email, String password, String phone, String address)
    {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }
}