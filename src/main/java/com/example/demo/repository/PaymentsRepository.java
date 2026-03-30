package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Collection;
import java.util.Optional;
import java.math.BigDecimal;
import com.example.demo.entity.PaymentsEntity;
import org.springframework.data.jpa.repository.Modifying;

@Repository
public interface PaymentsRepository extends JpaRepository<PaymentsEntity, Long> {

    Optional<PaymentsEntity> findByCustomerId(Long customerId);

    @Transactional
    @Query("SELECT COALESCE(SUM(e.amount), 0) FROM PaymentsEntity e WHERE e.customerId = :customerId")
    BigDecimal sumByCustomerId(@Param("customerId") Long customerId);

    @Transactional
    @Query("SELECT e.customerId, COALESCE(SUM(e.amount), 0) FROM PaymentsEntity e WHERE e.customerId IN :customerIdValues GROUP BY e.customerId")
    List<Object[]> sumByCustomerIdIn(@Param("customerIdValues") Collection<Long> customerIdValues);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO payments (PAYMENT_ID, CUSTOMER_ID, AMOUNT) VALUES (payments_seq.NEXTVAL, :customerId, :amount)", nativeQuery = true)
    void insertPayments(
                      @Param("customerId") Long customerId,
                      @Param("amount") BigDecimal amount);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM payments WHERE payment_id = :paymentId", nativeQuery = true)
    int deletePaymentsByPaymentId(@Param("paymentId") Long paymentId);

}
