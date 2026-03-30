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
import com.example.demo.entity.OrdersEntity;
import org.springframework.data.jpa.repository.Modifying;

@Repository
public interface OrdersRepository extends JpaRepository<OrdersEntity, Long> {

    Optional<OrdersEntity> findByCustomerId(Long customerId);

    @Transactional
    @Query("SELECT COALESCE(SUM(e.amount), 0) FROM OrdersEntity e WHERE e.customerId = :customerId")
    BigDecimal sumByCustomerId(@Param("customerId") Long customerId);

    @Transactional
    @Query("SELECT e.customerId, COALESCE(SUM(e.amount), 0) FROM OrdersEntity e WHERE e.customerId IN :customerIdValues GROUP BY e.customerId")
    List<Object[]> sumByCustomerIdIn(@Param("customerIdValues") Collection<Long> customerIdValues);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO orders (ORDER_ID, CUSTOMER_ID, AMOUNT) VALUES (orders_seq.NEXTVAL, :customerId, :amount)", nativeQuery = true)
    void insertOrders(
                      @Param("customerId") Long customerId,
                      @Param("amount") BigDecimal amount);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM orders WHERE order_id = :orderId", nativeQuery = true)
    int deleteOrdersByOrderId(@Param("orderId") Long orderId);

}
