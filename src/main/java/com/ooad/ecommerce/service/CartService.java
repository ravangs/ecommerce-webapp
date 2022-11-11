package com.ooad.ecommerce.service;

import com.ooad.ecommerce.dto.CartDto;
import com.ooad.ecommerce.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;


    private List<CartDto> getCartDetails(){

    }

    private void updateCartDetails(){

    }

}
