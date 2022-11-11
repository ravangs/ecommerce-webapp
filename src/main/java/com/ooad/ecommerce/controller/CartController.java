package com.ooad.ecommerce.controller;

import com.ooad.ecommerce.dto.CartDto;
import com.ooad.ecommerce.service.CartService;
import com.ooad.ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<CartDto> getCartDetails(){

    }

    @GetMapping
    public void updateCartDetails(){

    }
}
