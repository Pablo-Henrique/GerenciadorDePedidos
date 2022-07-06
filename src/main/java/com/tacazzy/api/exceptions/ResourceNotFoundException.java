package com.tacazzy.api.exceptions;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 6970384976404491997L;

    public ResourceNotFoundException(Object id) {
        super("Resource not found. id: " + id);
    }
}
