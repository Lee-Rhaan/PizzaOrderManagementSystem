package com.xgileit.PizzaOrderManagementSystem.infrastructure.exceptions;

public class CustomerNotRegisteredException extends RuntimeException{

    public CustomerNotRegisteredException(String message)
    {
        super(message);
    }
}
