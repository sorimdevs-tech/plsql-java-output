package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.example.demo.entity.CustomerBalanceEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDate;

@Repository
public interface CustomerBalanceRepository extends JpaRepository<CustomerBalanceEntity, Long> {

    Optional<CustomerBalanceEntity> findByCustomerId(Long customerId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO customer_balance (BALANCE_ID, CUSTOMER_ID, BALANCE, CREATED_AT, UPDATED_AT) VALUES (customer_balance_seq.NEXTVAL, :customerId, :balance, SYSDATE, :updatedAt)", nativeQuery = true)
    void insertCustomerBalance(
                      @Param("customerId") Long customerId,
                      @Param("balance") BigDecimal balance,
                      @Param("updatedAt") LocalDateTime updatedAt);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM customer_balance WHERE balance_id = :balanceId", nativeQuery = true)
    int deleteCustomerBalanceByBalanceId(@Param("balanceId") Long balanceId);

}
