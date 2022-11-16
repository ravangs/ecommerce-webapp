package com.ooad.ecommerce.service;

import com.ooad.ecommerce.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

  @Autowired private CartRepository cartRepository;

  @Autowired private ProductRepository productRepository;

  //  private List<CartDto> getCartDetails() {
  //    return null;
  //  }

  private void updateCartDetails() {}
}
