package com.ooad.ecommerce.service;

import com.ooad.ecommerce.dto.ProductDto;
import com.ooad.ecommerce.model.Product;
import com.ooad.ecommerce.repository.ProductRepository;
import com.ooad.ecommerce.repository.UserInfoRepository;
import com.ooad.ecommerce.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

  @Autowired private UserRepository userRepository;
  @Autowired private UserInfoRepository userInfoRepository;
  @Autowired private ProductRepository productRepository;

  public List<ProductDto> getAllProducts() {
    return productRepository.getAllBy().stream()
        .map(
            product ->
                ProductDto.builder()
                    .productInfo(new String(product.getProductInfo()))
                    .productImagePath(new String(product.getProductImagePath()))
                    .vendorId(product.getVendorId())
                    .id(product.getId())
                    .productName(product.getProductName())
                    .stock(product.getStock())
                    .cost(product.getCost())
                    .discount(product.getDiscount())
                    .build())
        .toList();
  }
}
