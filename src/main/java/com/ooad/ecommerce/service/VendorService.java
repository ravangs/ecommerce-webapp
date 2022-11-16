package com.ooad.ecommerce.service;

import com.ooad.ecommerce.dto.ProductDto;
import com.ooad.ecommerce.dto.UserInfoDto;
import com.ooad.ecommerce.repository.ProductRepository;
import com.ooad.ecommerce.repository.UserInfoRepository;
import com.ooad.ecommerce.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorService {

  @Autowired private UserRepository userRepository;
  @Autowired private UserInfoRepository userInfoRepository;
  @Autowired private ProductRepository productRepository;

  private void addProduct() {}

  private void updateProduct() {}

  private List<ProductDto> getMyProducts() {
    return null;
  }

  private UserInfoDto getUserDetails() {
    return null;
  }
}
