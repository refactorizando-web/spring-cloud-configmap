package com.refactorizando.controller;

import com.refactorizando.model.Order;
import com.refactorizando.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderRepository orderRepository;

    @Value("${spring.data.mongodb.username}")
    private String username;

    @Value("${spring.data.mongodb.password}")
    private String password;

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getOrders() {

        return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);

    }

    @PostMapping("/orders")
    public ResponseEntity<Order> saveOrder(@RequestBody Order order) {

        return new ResponseEntity<>(orderRepository.save(order), HttpStatus.CREATED);

    }

    @GetMapping("/")
    public ResponseEntity<String> info() throws UnknownHostException {

        String serviceInfo = "Host: " + InetAddress.getLocalHost().getHostName() + "<br/>"
                + "IP: " + InetAddress.getLocalHost().getHostAddress() + "<br/>"
                + "Type: " + "Order Service" + "<br/>"
                + "Connecting to mongodb with :  username:  " + username + " password: " + password;
        return new ResponseEntity<>(serviceInfo, HttpStatus.OK);
    }
}