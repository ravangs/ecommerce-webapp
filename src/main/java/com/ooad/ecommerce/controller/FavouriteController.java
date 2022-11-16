package com.ooad.ecommerce.controller;

import com.ooad.ecommerce.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FavouriteController {

  @Autowired private VendorService vendorService;

  //  @GetMapping
  //  public List<FavouriteDto> getFavouriteDetails() {
  //    return null;
  //  }

  //  @GetMapping
  //  public void updateFavouriteDetails() {}
}
