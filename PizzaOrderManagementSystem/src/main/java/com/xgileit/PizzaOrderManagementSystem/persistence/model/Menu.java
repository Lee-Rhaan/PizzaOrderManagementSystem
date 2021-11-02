package com.xgileit.PizzaOrderManagementSystem.persistence.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
public class Menu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String pizzaFlavours;
    private String pizzaSizes;
    private String beverages;
    private String beverageSizes;

    public Menu(String pizzaFlavours, String pizzaSizes, String beverages, String beverageSizes)
    {
        this.pizzaFlavours = pizzaFlavours;
        this.pizzaSizes = pizzaSizes;
        this.beverages = beverages;
        this.beverageSizes = beverageSizes;
    }
}
