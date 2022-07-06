package com.tacazzy.api.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@AllArgsConstructor
@Getter
@Setter
public class StandardError implements Serializable {

    @Serial
    private static final long serialVersionUID = -438244279989467403L;

    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

}
