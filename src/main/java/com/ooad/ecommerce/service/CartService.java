package com.ooad.ecommerce.service;

import com.ooad.ecommerce.dto.CartDto;
import com.ooad.ecommerce.repository.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

  @Autowired private CartRepository cartRepository;

  @Autowired private ProductRepository productRepository;

  private List<CartDto> getCartDetails() {}

  private void updateCartDetails() {}
}
