package com.ooad.ecommerce.service;

import com.ooad.ecommerce.dto.ProductDto;
import org.springframework.stereotype.Service;

@Service
public class UpdateProductHelperService {
  ProductDto product;

  public ProductDto getProduct() {
    return product;
  }

  public void setProduct(ProductDto product) {
    this.product = product;
  }
}
