package com.ooad.ecommerce.controller;

import com.ooad.ecommerce.dto.ProductDto;
import com.ooad.ecommerce.service.VendorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api")
public class VendorController {

  @Autowired private VendorService vendorService;

  @PostMapping("/product")
  public void addProduct() {}

  @PutMapping("/product")
  public void updateProduct() {}

  @GetMapping(value = "/user/products/{userId}", produces = "application/json")
  public List<ProductDto> getMyProducts(@PathVariable Integer userId) {
    return vendorService.getMyProducts(userId);
  }
}
