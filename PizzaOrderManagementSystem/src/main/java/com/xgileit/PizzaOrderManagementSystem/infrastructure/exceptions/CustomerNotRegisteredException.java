package com.xgileit.PizzaOrderManagementSystem.infrastructure.exceptions;

public class CustomerNotRegisteredException extends RuntimeException{

    /**
     * This constructor will take the message provided when a new instance of this exception is created,
     * and display it to the user.
     * @param message String
     */
    public CustomerNotRegisteredException(String message)
    {
        super(message);
    }
}
