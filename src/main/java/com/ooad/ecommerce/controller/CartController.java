package com.ooad.ecommerce.controller;

import com.ooad.ecommerce.dto.CartDto;
import com.ooad.ecommerce.service.CartService;
import com.ooad.ecommerce.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api")
public class CartController {

  @Autowired private CartService cartService;

  @Autowired private CustomerService customerService;

  @GetMapping("/cart/{userId}")
  public List<CartDto> getCartDetails(@PathVariable String userId) {
    return null;
  }

  @PutMapping("/cart/{userId}")
  public void updateCartDetails(@PathVariable String userId) {
    /* TODO document why this method is empty */
  }
}
