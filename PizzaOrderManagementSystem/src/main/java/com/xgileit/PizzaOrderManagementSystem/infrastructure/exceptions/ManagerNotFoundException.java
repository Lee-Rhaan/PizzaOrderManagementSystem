package com.xgileit.PizzaOrderManagementSystem.infrastructure.exceptions;


public class ManagerNotFoundException extends RuntimeException {

    public ManagerNotFoundException(String message)
    {
        super(message);
    }
}
