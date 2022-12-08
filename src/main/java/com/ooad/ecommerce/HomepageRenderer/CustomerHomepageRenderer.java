package com.ooad.ecommerce.HomepageRenderer;

import com.ooad.ecommerce.controller.CatalogController;
import com.ooad.ecommerce.dto.ProductDto;
import com.ooad.ecommerce.service.AuthService;
import com.ooad.ecommerce.views.CardLayoutHelper;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import java.util.List;


// This is an example of Strategy Pattern
// This is a Concrete Algorithm Class in the pattern

public class CustomerHomepageRenderer extends HorizontalLayout implements RenderBehavior {

  @Override
  public Component renderHomepage(AuthService authService, CatalogController catalogController) {
    CardLayoutHelper cardLayoutHelper = new CardLayoutHelper();
    List<ProductDto> products = catalogController.getProducts();
    Div cards = new Div();
    cards.addClassName("row");
    for (ProductDto product : products) {
      cards.add(cardLayoutHelper.createColumn(product, authService.getUserType()));
    }
    add(cards);
    return this;
  }
}
