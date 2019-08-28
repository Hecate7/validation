package com.demo.validation.common.exception;

import lombok.Data;

@Data
public class ParamErrorException extends RuntimeException {
    private String name;
    private String value;
    private String message;

    public ParamErrorException(String name, String value, String message) {
        this.name = name;
        this.value = value;
        this.message = message;
    }
}
