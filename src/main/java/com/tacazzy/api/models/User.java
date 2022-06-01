package com.tacazzy.api.models;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "TB_USER")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = -6707608294685089204L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 16)
    private UUID id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private String password;

    @OneToMany(mappedBy = "client")
    @ToString.Exclude
    @Setter(AccessLevel.NONE)
    private List<Order> orders = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
