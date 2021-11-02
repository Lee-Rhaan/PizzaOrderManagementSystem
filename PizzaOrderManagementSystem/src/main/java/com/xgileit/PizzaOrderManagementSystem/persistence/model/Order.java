package com.xgileit.PizzaOrderManagementSystem.persistence.model;

import com.xgileit.PizzaOrderManagementSystem.infrastructure.enums.OrderStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String pizzaAmount;
    private String beverageAmount;
    private String pizzaFlavour;
    private String pizzaSize;
    private String beverage;
    private String beverageSize;
    private OrderStatus orderStatus;

    @ManyToOne
    private Customer customerOrder;

    public Order(String pizzaAmount, String beverageAmount, String pizzaFlavour, String pizzaSize,
                 String beverage, String beverageSize)
    {
        this.pizzaAmount = pizzaAmount;
        this.beverageAmount = beverageAmount;
        this.pizzaFlavour = pizzaFlavour;
        this.pizzaSize = pizzaSize;
        this.beverage = beverage;
        this.beverageSize = beverageSize;
    }
}
