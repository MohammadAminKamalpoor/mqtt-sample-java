package com.mqtt.sample.model;

public class Order {

    private String orderId;

    private String userId;

    private String orderDate;

    private String amount;

    public Order() {
    }

    public Order(String orderId, String userId, String orderDate, String amount) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderDate = orderDate;
        this.amount = amount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}

