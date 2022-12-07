package com.ooad.ecommerce.controller;

import com.ooad.ecommerce.model.Product;
import com.ooad.ecommerce.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class FavouriteController {

  @Autowired private VendorService vendorService;

  @GetMapping("/favourites/{userId}")
  public List<Product> getFavouriteDetails(@PathVariable String userId) {
    return null;
  }

  @PutMapping("/favourites/{userId}")
  public void updateFavouriteDetails(@PathVariable String userId) {
    /* TODO document why this method is empty */
  }
}
