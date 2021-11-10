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

    @Column(name = "pizza_flavour")
    private String pizzaFlavour;

    @Column(name = "pizza_size")
    private String pizzaSize;

    private String beverage;

    @Column(name = "beverage_size")
    private String beverageSize;

    public Menu(String pizzaFlavour, String pizzaSize, String beverage, String beverageSize)
    {
        this.pizzaFlavour = pizzaFlavour;
        this.pizzaSize = pizzaSize;
        this.beverage = beverage;
        this.beverageSize = beverageSize;
    }
}
