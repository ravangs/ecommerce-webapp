package com.ooad.ecommerce.HomepageRenderer;

import com.ooad.ecommerce.controller.CatalogController;
import com.ooad.ecommerce.dto.ProductDto;
import com.ooad.ecommerce.service.AuthService;
import com.ooad.ecommerce.views.CardLayoutHelper;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route
public class VendorHomepageRenderer extends VerticalLayout implements RenderBehavior {

  @Override
  public Component renderHomepage(AuthService authService, CatalogController catalogController) {
    CardLayoutHelper cardLayoutHelper = new CardLayoutHelper();
    Button plusButton = new Button(new Icon(VaadinIcon.PLUS));
    plusButton.addThemeVariants(ButtonVariant.LUMO_ICON);
    plusButton.setText("Add Product");
    plusButton.addClickListener(
        e -> {
          UI.getCurrent().navigate("new-product");
        });
    List<ProductDto> products = catalogController.getCurrentVendorProducts(authService.getUserId());
    Div cards = new Div();
    cards.addClassName("row");
    for (ProductDto product : products) {
      cards.add(cardLayoutHelper.createColumn(product));
    }
    add(cards, plusButton);
    this.setPadding(false);
    return this;
  }
}
