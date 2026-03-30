package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.math.BigDecimal;

@Entity
@Table(name = "BALANCE_AUDIT_LOG")
public class BalanceAuditLogEntity {

    @Id
    @SequenceGenerator(name = "seq_auditId", sequenceName = "AUDIT_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_auditId")
    @Column(name = "AUDIT_ID")
    private Long auditId;

    @Column(name = "CUSTOMER_ID")
    private Long customerId;

    @Column(name = "OLD_BALANCE")
    private BigDecimal oldBalance;

    @Column(name = "NEW_BALANCE")
    private BigDecimal newBalance;

    @Column(name = "ACTION_DATE")
    private LocalDateTime actionDate;

    public Long getAuditId() {
        return auditId;
    }

    public void setAuditId(Long auditId) {
        this.auditId = auditId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getOldBalance() {
        return oldBalance;
    }

    public void setOldBalance(BigDecimal oldBalance) {
        this.oldBalance = oldBalance;
    }

    public BigDecimal getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(BigDecimal newBalance) {
        this.newBalance = newBalance;
    }

    public LocalDateTime getActionDate() {
        return actionDate;
    }

    public void setActionDate(LocalDateTime actionDate) {
        this.actionDate = actionDate;
    }
}
