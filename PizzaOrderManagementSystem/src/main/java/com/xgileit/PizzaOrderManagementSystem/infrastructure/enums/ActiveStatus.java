package com.xgileit.PizzaOrderManagementSystem.infrastructure.enums;

/**
 * This enum class allows me to set the Status of the users in this Pizza Order System
 * with predefined enum constants
 */

public enum ActiveStatus {
    LOGGED_OUT("LOGGED_OUT"), LOGGED_IN("LOGGED_IN");

    private final String activeStatus;

    /**
     * Initializing status variable with argument provided in parameters
     *
     * @param activeStatus String
     */
    ActiveStatus(String activeStatus)
    {
        this.activeStatus = activeStatus;
    }

    /**
     * @return Status of specified object
     */
    public String getStatus()
    {
        return activeStatus;
    }
}
