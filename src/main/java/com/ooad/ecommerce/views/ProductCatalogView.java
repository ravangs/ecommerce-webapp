package com.ooad.ecommerce.views;

import com.ooad.ecommerce.HomepageRenderer.RenderBehavior;
import com.ooad.ecommerce.controller.CatalogController;
import com.ooad.ecommerce.dto.UserInfoDto;
import com.ooad.ecommerce.model.Product;
import com.ooad.ecommerce.service.AuthService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import java.util.List;

@Route
public class ProductCatalogView extends VerticalLayout {

  RenderBehavior renderBehavior;
  public ProductCatalogView(AuthService authService, CatalogController catalogController, RenderBehavior renderBehavior) {
    add(renderBehavior.renderHomepage(authService, catalogController));
  }

}
