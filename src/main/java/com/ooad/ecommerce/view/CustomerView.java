package com.ooad.ecommerce.view;

import com.ooad.ecommerce.controller.CustomerController;
import com.ooad.ecommerce.dto.UserInfoDto;
import com.ooad.ecommerce.model.Product;
import java.util.List;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class CustomerView extends CustomerController {

  private List<Product> getProductsList() {
    return null;
  }

  public UserInfoDto getUserDetails() {
    return null;
  }
}
