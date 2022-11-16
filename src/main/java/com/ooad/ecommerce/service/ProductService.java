package com.ooad.ecommerce.service;

import com.ooad.ecommerce.dto.ProductDto;
import com.ooad.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  @Autowired private ProductRepository productRepository;

  public ProductDto getProductDetails() {
    return null;
  }
}
