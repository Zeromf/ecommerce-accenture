package org.accenture.exception;

import lombok.Data;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}