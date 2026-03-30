package com.example.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PAYMENTS")
public class PaymentsEntity {

    @Id
    @SequenceGenerator(name = "seq_paymentId", sequenceName = "payments_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_paymentId")
    @Column(name = "PAYMENT_ID")
    private Long paymentId;

    @Column(name = "CUSTOMER_ID")
    private Long customerId;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
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
