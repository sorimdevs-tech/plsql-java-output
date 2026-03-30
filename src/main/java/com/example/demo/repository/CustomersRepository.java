package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;
import com.example.demo.entity.CustomersEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CustomersRepository extends JpaRepository<CustomersEntity, Long> {

    Optional<CustomersEntity> findByStatus(String status);

    @Query(value = "SELECT * FROM customers WHERE status = :status FOR UPDATE SKIP LOCKED", nativeQuery = true)
    Page<CustomersEntity> findPageForUpdateSkipLockedByStatus(@Param("status") String status, Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO customers (CUSTOMER_ID, STATUS) VALUES (customers_seq.NEXTVAL, :status)", nativeQuery = true)
    void insertCustomers(
                      @Param("status") String status);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM customers WHERE customer_id = :customerId", nativeQuery = true)
    int deleteCustomersByCustomerId(@Param("customerId") Long customerId);

}
