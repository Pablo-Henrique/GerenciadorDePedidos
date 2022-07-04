package com.tacazzy.api.controllers;

import com.tacazzy.api.models.Order;
import com.tacazzy.api.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(path = "/orders")
    public ResponseEntity<List<Order>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findAll());
    }

    @GetMapping(path = "/order/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findById(id));
    }
}
