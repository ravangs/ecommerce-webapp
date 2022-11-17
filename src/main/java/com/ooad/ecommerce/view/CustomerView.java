package com.ooad.ecommerce.view;

import com.ooad.ecommerce.dto.UserInfoDto;
import com.ooad.ecommerce.model.Product;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@NoArgsConstructor
public class CustomerView {

  private List<Product> getProductsList() {
    return null;
  }

  public UserInfoDto getUserDetails() {
    return null;
  }
}
