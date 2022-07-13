package com.tacazzy.api.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT")
    private Instant timestamp;

    private Integer status;
    private String error;
    private String message;
    private String path;
}
