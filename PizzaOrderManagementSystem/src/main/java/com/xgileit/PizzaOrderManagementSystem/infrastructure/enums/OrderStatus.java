package com.xgileit.PizzaOrderManagementSystem.infrastructure.enums;

/**
 * This enum class allows me to set the Status of the Order objects in this Pizza Order System
 * with predefined enum constants
 */

public enum OrderStatus {
    PENDING("PENDING"), TRANSFERRED("TRANSFERRED"), PREPARED("PREPARED"), DELIVERED("DELIVERED");

    private final String orderStatus;

    /**
     * Initializing orderStatus variable with argument provided in parameters
     *
     * @param orderStatus String
     */
    OrderStatus(String orderStatus)
    {
        this.orderStatus = orderStatus;
    }

    /**
     * @return orderStatus of specified object
     */
    public String getOrderStatus()
    {
        return orderStatus;
    }
}
