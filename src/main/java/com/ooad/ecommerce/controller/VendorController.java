package com.ooad.ecommerce.controller;

import com.ooad.ecommerce.dto.ProductDto;
import com.ooad.ecommerce.dto.UserInfoDto;
import com.ooad.ecommerce.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @GetMapping
    public void addProduct(){

    }

    @GetMapping
    public void updateProduct(){

    }

    @GetMapping
    public List<ProductDto> getMyProducts(){

    }

    @GetMapping
    public UserInfoDto getUserDetails(){

    }
}
