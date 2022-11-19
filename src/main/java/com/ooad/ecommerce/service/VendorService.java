package com.ooad.ecommerce.service;

import com.ooad.ecommerce.dto.ProductDto;
import com.ooad.ecommerce.repository.ProductRepository;
import com.ooad.ecommerce.repository.UserInfoRepository;
import com.ooad.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendorService {

  @Autowired private UserRepository userRepository;
  @Autowired private UserInfoRepository userInfoRepository;
  @Autowired private ProductRepository productRepository;

  private void addProduct() {}

  private void updateProduct() {}

  public List<ProductDto> getMyProducts(Integer vendorId) {
    return productRepository.getProductsByVendorId(vendorId).stream()
            .map(product -> ProductDto.builder()
            .productInfo(new String(product.getProductInfo()))
            .productImagePath(new String(product.getProductImagePath()))
            .vendorId(product.getVendorId())
            .id(product.getId())
            .productName(product.getProductName())
            .stock(product.getStock())
            .cost(product.getCost())
            .discount(product.getDiscount())
            .build())
            .collect(Collectors.toList());
  }
}
