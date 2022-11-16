package com.ooad.ecommerce.controller;

import com.ooad.ecommerce.service.CartService;
import com.ooad.ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

  @Autowired private CartService cartService;

  @Autowired private CustomerService customerService;

  //  @GetMapping("/cart")
  //  public List<CartDto> getCartDetails() {
  //    return null;
  //  }

  //  @GetMapping
  //  public void updateCartDetails() {}
}
