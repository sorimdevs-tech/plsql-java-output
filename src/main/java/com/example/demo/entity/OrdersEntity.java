package com.example.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ORDERS")
public class OrdersEntity {

    @Id
    @SequenceGenerator(name = "seq_orderId", sequenceName = "orders_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_orderId")
    @Column(name = "ORDER_ID")
    private Long orderId;

    @Column(name = "CUSTOMER_ID")
    private Long customerId;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
