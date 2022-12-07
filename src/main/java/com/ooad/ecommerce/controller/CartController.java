package com.ooad.ecommerce.controller;

import com.ooad.ecommerce.dto.ModifyCartDto;
import com.ooad.ecommerce.model.Product;
import com.ooad.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/api")
public class CartController {

  @Autowired private CartService cartService;

  @GetMapping("/cart/{userId}")
  public Map<Product, Integer> getCartDetails(@PathVariable Integer userId) {
    return cartService.getCartDetails(userId);
  }

  @PostMapping(
          value = "/cart/add",
          consumes = {MediaType.APPLICATION_JSON_VALUE},
          produces = {MediaType.APPLICATION_JSON_VALUE})
  public Map<Product,Integer> modifyCart(@RequestBody List<ModifyCartDto> cartEntryDetails) {
    return cartService.modifyCart(cartEntryDetails);
  }

  @PutMapping(value = "/cart/clear/{userId}")
  public void clearCart(@PathVariable Integer userId){
    cartService.clearCart(userId);
  }

}
