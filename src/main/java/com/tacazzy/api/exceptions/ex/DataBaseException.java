package com.tacazzy.api.exceptions.ex;

import java.io.Serial;

public class DataBaseException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 2585564399205334503L;

    public DataBaseException(String message) {
        super(message);
    }
}
