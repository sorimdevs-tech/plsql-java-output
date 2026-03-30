package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.BalanceAuditLogEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDate;

@Repository
public interface BalanceAuditLogRepository extends JpaRepository<BalanceAuditLogEntity, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO balance_audit_log (AUDIT_ID, CUSTOMER_ID, OLD_BALANCE, NEW_BALANCE, ACTION_DATE) VALUES (balance_audit_log_seq.NEXTVAL, :customerId, :oldBalance, :newBalance, :actionDate)", nativeQuery = true)
    void insertBalanceAuditLog(
                      @Param("customerId") Long customerId,
                      @Param("oldBalance") BigDecimal oldBalance,
                      @Param("newBalance") BigDecimal newBalance,
                      @Param("actionDate") LocalDateTime actionDate);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM balance_audit_log WHERE audit_id = :auditId", nativeQuery = true)
    int deleteBalanceAuditLogByAuditId(@Param("auditId") Long auditId);

}
