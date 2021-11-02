package com.xgileit.PizzaOrderManagementSystem.infrastructure.enums;

public enum OrderStatus {
    PENDING("PENDING"), PREPARED("PREPARED"), DELIVERED("DELIVERED");

    private final String orderStatus;

    OrderStatus(String orderStatus)
    {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatus()
    {
        return orderStatus;
    }
}
