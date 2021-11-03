package com.xgileit.PizzaOrderManagementSystem.persistence.model;

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
    private Long id;
    private String username;
    private String email;
    private String password;
    private String phone;
    private String address;

    @Column(name = "employee_code")
    private String employeeCode = UUID.randomUUID().toString();

    public Chef(String username, String email, String password, String phone, String address)
    {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }
}
