package com.ooad.ecommerce.controller;

import com.ooad.ecommerce.model.Order;
import com.ooad.ecommerce.model.Product;
import com.ooad.ecommerce.service.CartService;
import com.ooad.ecommerce.service.OrderService;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api")
public class OrderController {

  @Autowired private OrderService orderService;

  @Autowired private CartService cartService;

  @PostMapping(value = "/order/{userId}")
  public void placeOrder(@PathVariable Integer userId) {
    orderService.placeOrder(userId, cartService.getCartDetails(userId));
    cartService.clearCart(userId);
  }

  @GetMapping(value = "/orders/{userId}")
  public List<Order> getOrders(@PathVariable Integer userId) {
    return orderService.getOrders(userId);
  }

  @GetMapping(value = "/order/{orderId}")
  public Map<Product, Integer> getOrderByOrderId(@PathVariable Integer orderId) {
    return orderService.getOrder(orderId);
  }
}
