package com.ooad.ecommerce.view;

import com.ooad.ecommerce.controller.CustomerController;
import com.ooad.ecommerce.dto.UserInfoDto;
import com.ooad.ecommerce.model.Product;
import com.ooad.ecommerce.service.RestClientService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@NoArgsConstructor
public class CustomerView extends CustomerController {

    private List<Product> getProductsList(){

    }

    private UserInfoDto getUserDetails(){

    }
}
