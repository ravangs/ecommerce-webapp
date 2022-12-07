package com.ooad.ecommerce.controller;

import com.ooad.ecommerce.dto.ProductDto;
import com.ooad.ecommerce.service.CustomerService;
import com.ooad.ecommerce.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class CatalogController {
  @Autowired private VendorService vendorService;
  @Autowired  private CustomerService customerService;


  public List<ProductDto> getCurrentVendorProducts(@PathVariable Integer userId) {
    return vendorService.getMyProducts(userId);
  }

  public List<ProductDto> getProducts() {
    return customerService.getAllProducts();
  }
}
