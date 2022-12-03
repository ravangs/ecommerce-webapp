package com.ooad.ecommerce.controller;

import com.ooad.ecommerce.dto.ProductDto;
import com.ooad.ecommerce.service.VendorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api")
public class VendorController {

  @Autowired private VendorService vendorService;

  @PostMapping(value="/product",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
  public Integer addProduct(@RequestBody ProductDto product) {
    return vendorService.addProduct(product);
  }

  @PutMapping(value="/product",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
  public Integer updateProduct(@RequestBody ProductDto product) {
    return vendorService.updateProduct(product);
  }

  @GetMapping(value = "/user/products/{userId}", produces = "application/json")
  public List<ProductDto> getMyProducts(@PathVariable Integer userId) {
    return vendorService.getMyProducts(userId);
  }
}
