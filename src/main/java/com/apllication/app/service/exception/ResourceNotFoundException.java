package com.apllication.app.service.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Object id) {
        super("Resource not sound .Id" + id);
    }
}
