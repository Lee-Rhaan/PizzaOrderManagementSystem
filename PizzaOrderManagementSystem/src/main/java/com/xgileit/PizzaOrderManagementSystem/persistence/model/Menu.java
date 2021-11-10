package com.xgileit.PizzaOrderManagementSystem.persistence.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * This is the Menu Entity class which will be mapped to the database.
 * This entity will store all the products in this Pizza Order System.
 */
@Data
@NoArgsConstructor
@Entity
public class Menu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long menuId;

    @Column(name = "pizza_flavours")
    private String pizzaFlavours;

    @Column(name = "pizza_sizes")
    private String pizzaSizes;

    private String beverages;

    @Column(name = "beverage_sizes")
    private String beverageSizes;

    public Menu(String pizzaFlavours, String pizzaSizes, String beverages, String beverageSizes)
    {
        this.pizzaFlavours = pizzaFlavours;
        this.pizzaSizes = pizzaSizes;
        this.beverages = beverages;
        this.beverageSizes = beverageSizes;
    }
}
