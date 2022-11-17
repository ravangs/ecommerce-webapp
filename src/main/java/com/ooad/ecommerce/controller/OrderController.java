package com.ooad.ecommerce.controller;

import com.ooad.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
public class OrderController {

  @Autowired private OrderService orderService;

  @PostMapping("/order")
  public void placeOrder() {}
}
