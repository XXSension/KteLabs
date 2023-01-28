package com.springboot.KteLabs.exception_handling;

public class NoSuchTicketException extends RuntimeException {
    public NoSuchTicketException(String message) {
        super(message);
    }
}
