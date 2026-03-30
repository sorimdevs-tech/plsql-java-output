package com.example.demo.dto;

import java.io.Serializable;

public abstract class BaseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    public abstract Object toEntity();

    public static <T extends BaseDTO> T fromEntity(Object entity) {
        throw new UnsupportedOperationException("Implement in concrete DTO classes");
    }
}
