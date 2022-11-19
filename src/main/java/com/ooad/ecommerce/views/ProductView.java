package com.ooad.ecommerce.views;

import com.ooad.ecommerce.dto.ProductDto;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;

import javax.annotation.security.PermitAll;

@Route("product/:product_id")
@PermitAll
public class ProductView extends VerticalLayout implements BeforeEnterObserver {

  String productId;
  ProductView() {
    add(new H1("Product " + productId));
  }


  @Override
  public void beforeEnter(BeforeEnterEvent event) {
    productId = event.getRouteParameters().get("product_id").get();
  }

  public ProductDto getProductDetails() {
    return null;
  }
}
