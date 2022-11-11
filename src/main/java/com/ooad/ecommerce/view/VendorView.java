package com.ooad.ecommerce.view;

import com.ooad.ecommerce.controller.VendorController;
import com.ooad.ecommerce.dto.ProductDto;
import com.ooad.ecommerce.dto.UserInfoDto;
import java.util.List;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class VendorView extends VendorController {

  private void postProduct() {}

  private void putProduct() {}

  private List<ProductDto> getMyProducts() {}

  private UserInfoDto getUserDetails() {}
}
