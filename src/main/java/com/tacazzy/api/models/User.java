package com.tacazzy.api.models;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = -6707608294685089204L;

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;

}
