package com.xgileit.PizzaOrderManagementSystem.persistence.model;

import com.xgileit.PizzaOrderManagementSystem.infrastructure.enums.OrderStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * This is the Order Entity class which will be mapped to the database.
 * This entity will store all the orders in this Pizza Order System.
 */
@Table(name = "orders")
@Data
@NoArgsConstructor
@Entity
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "pizza_amount")
    private String amountOfPizzas;

    @Column(name = "beverage_amount")
    private String amountOfBeverages;

    @Column(name = "pizza_flavour")
    private String pizzaFlavour;

    @Column(name = "pizza_size")
    private String pizzaSize;

    private String beverage;

    @Column(name = "beverage_size")
    private String beverageSize;

    @Column(name = "order_status")
    private OrderStatus orderStatus;

    @ManyToOne
    private Customer customerOrder;

    public Order(String amountOfPizzas, String amountOfBeverages, String pizzaFlavour, String pizzaSize,
                 String beverage, String beverageSize)
    {
        this.amountOfPizzas = amountOfPizzas;
        this.amountOfBeverages = amountOfBeverages;
        this.pizzaFlavour = pizzaFlavour;
        this.pizzaSize = pizzaSize;
        this.beverage = beverage;
        this.beverageSize = beverageSize;
    }

}
