package com.ooad.ecommerce.controller;

import com.ooad.ecommerce.dto.FavouriteDto;
import com.ooad.ecommerce.service.VendorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api")
public class FavouriteController {

  @Autowired private VendorService vendorService;

  @GetMapping("/favourites/{userId}")
  public List<FavouriteDto> getFavouriteDetails(@PathVariable String userId) {
    return null;
  }

  @PutMapping("/favourites/{userId}")
  public void updateFavouriteDetails(@PathVariable String userId) {
    /* TODO document why this method is empty */
  }
}
