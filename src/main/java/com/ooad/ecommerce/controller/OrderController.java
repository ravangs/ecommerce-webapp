package com.ooad.ecommerce.controller;

import com.ooad.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

  @Autowired private OrderService orderService;

//  @GetMapping
//  public void placeOrder() {}
}
