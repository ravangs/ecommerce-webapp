package com.ooad.ecommerce.view;

import com.ooad.ecommerce.controller.ProductController;
import com.ooad.ecommerce.dto.ProductDto;
import com.ooad.ecommerce.service.RestClientService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class ProductView extends ProductController {

    public ProductDto getProductDetails(){

    }
}
