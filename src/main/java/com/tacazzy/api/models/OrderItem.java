package com.tacazzy.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tacazzy.api.models.pk.OrderItemPk;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "TB_ORDER_ITEM")
public class OrderItem implements Serializable {

    @Serial
    private static final long serialVersionUID = 8613687247797688516L;

    @EmbeddedId
    private final OrderItemPk id = new OrderItemPk();

    @Column
    private Integer quantity;

    @Column
    private Double price;

    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    @JsonIgnore
    public Order getOrder() {
        return id.getOrder();
    }

    public void setOrder(Order order) {
        id.setOrder(order);
    }

    @JsonIgnore
    public Product getProduct() {
        return id.getProduct();
    }

    public Double getSubTotal() {
        return price * quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OrderItem orderItem = (OrderItem) o;
        return id != null && Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
