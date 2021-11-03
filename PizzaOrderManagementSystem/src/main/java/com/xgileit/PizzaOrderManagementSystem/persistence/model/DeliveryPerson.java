package com.xgileit.PizzaOrderManagementSystem.persistence.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
public class DeliveryPerson implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String email;
    private String password;
    private String phone;
    private String address;
   // private List<Order> orders;
    //The delivery person should not register when he wants to access the website.
    private String employeeCode = UUID.randomUUID().toString();

    public DeliveryPerson(String username, String email, String password, String phone, String address)
    {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }
}
