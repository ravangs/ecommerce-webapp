package com.ooad.ecommerce.controller;

import com.ooad.ecommerce.dto.ProductDto;
import com.ooad.ecommerce.dto.UserInfoDto;
import com.ooad.ecommerce.service.CustomerService;
import com.ooad.ecommerce.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

  @Autowired private CustomerService customerService;

  @Autowired private ProductService productService;

  @GetMapping
  public List<ProductDto> getAllProducts() {}

  @GetMapping
  public List<ProductDto> getFilteredProducts() {}

  @GetMapping
  public UserInfoDto getUserDetails() {}
}
