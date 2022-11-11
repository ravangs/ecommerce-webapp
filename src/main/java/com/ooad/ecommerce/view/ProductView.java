package com.ooad.ecommerce.view;

import com.ooad.ecommerce.controller.ProductController;
import com.ooad.ecommerce.dto.ProductDto;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class ProductView extends ProductController {

  public ProductDto getProductDetails() {}
}
