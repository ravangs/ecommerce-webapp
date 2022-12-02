package com.ooad.ecommerce.service;

import com.ooad.ecommerce.dto.ProductDto;
import com.ooad.ecommerce.model.Product;
import com.ooad.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  @Autowired private ProductRepository productRepository;

  public ProductDto getProductDetails(Integer productId) {
    Product product = productRepository.getProductById(productId);
    return this.convertProductToProductDto(product);
  }

  public ProductDto convertProductToProductDto(Product product) {
    return ProductDto.builder()
        .productInfo(new String(product.getProductInfo()))
        .productImagePath(new String(product.getProductImagePath()))
        .vendorId(product.getVendorId())
        .id(product.getId())
        .productName(product.getProductName())
        .stock(product.getStock())
        .cost(product.getCost())
        .discount(product.getDiscount())
        .build();
  }
}
