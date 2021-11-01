package com.xgileit.PizzaOrderManagementSystem.persistence.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String email;
    private String password;
    private String phone;
    private String address;
    @Column(name = "code")
    private String customerCode = null;

    //mappedBy indicates that this side is the inverse side, and that the mapping is defined
    //by the attribute customerOrder at the other side of the association.
    @OneToMany(mappedBy = "customerOrder")
    private List<Order> orders;

    //mappedBy indicates that this side is the inverse side, and that the mapping is defined
    //by the attribute customerReview at the other side of the association.
    @OneToMany(mappedBy = "customerReview")
    private List<Review> review;

    public Customer(String username, String email, String password, String phone, String address)
    {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }

}
