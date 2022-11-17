package com.ooad.ecommerce.controller;

import com.ooad.ecommerce.dto.ProductDto;
import com.ooad.ecommerce.dto.UserInfoDto;
import com.ooad.ecommerce.service.CustomerService;
import com.ooad.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class CustomerController {

  @Autowired private CustomerService customerService;

  @Autowired private ProductService productService;

    @GetMapping("/products")
    public List<ProductDto> getAllProducts() {
      return null;
    }

    @GetMapping("/products/{vendorId}")
    public List<ProductDto> getFilteredProducts(@PathVariable String vendorId) {
      return null;
    }

    @GetMapping("/user/{userId}")
    public UserInfoDto getUserDetails(@PathVariable String userId) {
      return null;
    }
}
