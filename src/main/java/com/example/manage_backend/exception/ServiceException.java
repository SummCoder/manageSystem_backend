package com.example.manage_backend.exception;

import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {

    private Integer code;

    public ServiceException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
