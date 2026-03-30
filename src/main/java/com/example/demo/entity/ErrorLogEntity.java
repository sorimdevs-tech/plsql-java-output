package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ERROR_LOG")
public class ErrorLogEntity {

    @Id
    @SequenceGenerator(name = "seq_errorId", sequenceName = "ERROR_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_errorId")
    @Column(name = "ERROR_ID")
    private Long errorId;

    @Column(name = "ERROR_MESSAGE")
    private String errorMessage;

    @Column(name = "ERROR_DATE")
    private LocalDateTime errorDate;

    public Long getErrorId() {
        return errorId;
    }

    public void setErrorId(Long errorId) {
        this.errorId = errorId;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public LocalDateTime getErrorDate() {
        return errorDate;
    }

    public void setErrorDate(LocalDateTime errorDate) {
        this.errorDate = errorDate;
    }
}
