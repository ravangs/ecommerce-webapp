package com.ooad.ecommerce.controller;

import com.ooad.ecommerce.dto.FavouriteDto;
import com.ooad.ecommerce.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FavouriteController {

    @Autowired
    private VendorService vendorService;

    @GetMapping
    public List<FavouriteDto> getFavouriteDetails(){

    }

    @GetMapping
    public void updateFavouriteDetails(){

    }
}
