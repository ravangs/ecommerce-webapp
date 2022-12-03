package com.ooad.ecommerce.service;

import com.ooad.ecommerce.dto.ProductDto;
import com.ooad.ecommerce.model.Product;
import com.ooad.ecommerce.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorService {

  @Autowired private ProductRepository productRepository;

  public Integer addProduct(ProductDto product) {
    Product savedProduct = productRepository.save(product.convertDtoToEntity());
    return savedProduct.getId();
  }

  public Integer updateProduct(ProductDto product) {
    Product updatedProduct = productRepository.save(product.convertDtoToEntity());
    return updatedProduct.getId();
  }

  public List<ProductDto> getMyProducts(Integer vendorId) {
    return productRepository.getProductsByVendorId(vendorId).stream()
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
