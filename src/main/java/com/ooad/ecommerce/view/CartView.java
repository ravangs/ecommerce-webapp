package com.ooad.ecommerce.view;

import com.ooad.ecommerce.controller.CartController;
import com.ooad.ecommerce.dto.CartDto;
import java.util.List;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class CartView extends CartController {

  private boolean putCartDetails() {
    return false;
  }
}
