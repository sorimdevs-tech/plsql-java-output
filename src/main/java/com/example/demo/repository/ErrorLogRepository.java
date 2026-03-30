package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.ErrorLogEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDateTime;
import java.time.LocalDate;

@Repository
public interface ErrorLogRepository extends JpaRepository<ErrorLogEntity, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO error_log (ERROR_ID, ERROR_MESSAGE, ERROR_DATE) VALUES (error_log_seq.NEXTVAL, :errorMessage, :errorDate)", nativeQuery = true)
    void insertErrorLog(
                      @Param("errorMessage") String errorMessage,
                      @Param("errorDate") LocalDateTime errorDate);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM error_log WHERE error_id = :errorId", nativeQuery = true)
    int deleteErrorLogByErrorId(@Param("errorId") Long errorId);

}
