package com.tacazzy.api.repositories;

import com.tacazzy.api.models.OrderItem;
import com.tacazzy.api.models.pk.OrderItemPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk> {
}