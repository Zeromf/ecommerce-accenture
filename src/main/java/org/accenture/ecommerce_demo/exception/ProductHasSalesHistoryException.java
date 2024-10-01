package org.accenture.exception;

public class ProductHasSalesHistoryException extends RuntimeException {
    public ProductHasSalesHistoryException(String message) {
        super(message);
    }
}