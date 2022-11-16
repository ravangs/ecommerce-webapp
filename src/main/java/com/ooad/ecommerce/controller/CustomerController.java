package com.ooad.ecommerce.controller;

import com.ooad.ecommerce.service.CustomerService;
import com.ooad.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

  @Autowired private CustomerService customerService;

  @Autowired private ProductService productService;

  //  @GetMapping
  //  public List<ProductDto> getAllProducts() {
  //    return null;
  //  }
  //
  //  @GetMapping
  //  public List<ProductDto> getFilteredProducts() {
  //    return null;
  //  }

  //  @GetMapping
  //  public UserInfoDto getUserDetails() {
  //    return null;
  //  }
}
