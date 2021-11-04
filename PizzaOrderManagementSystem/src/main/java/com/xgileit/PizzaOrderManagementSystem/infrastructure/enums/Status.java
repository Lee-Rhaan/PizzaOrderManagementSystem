package com.xgileit.PizzaOrderManagementSystem.infrastructure.enums;

/**
 * This enum class allows me to set the Status of the users  in this Pizza Order System
 * with predefined enum constants
 */

public enum Status {
    LOGGED_OUT("LOGGED_OUT"), LOGGED_IN("LOGGED_IN");

    private final String status;

    /**
     * Initializing status variable with argument provided in parameters
     *
     * @param status String
     */
    Status(String status)
    {
        this.status = status;
    }

    /**
     * @return Status of specified object
     */
    public String getStatus()
    {
        return status;
    }
}
