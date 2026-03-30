package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CUSTOMERS")
public class CustomersEntity {

    @Id
    @SequenceGenerator(name = "seq_customerId", sequenceName = "customers_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_customerId")
    @Column(name = "CUSTOMER_ID")
    private Long customerId;

    @Column(name = "STATUS")
    private String status;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
