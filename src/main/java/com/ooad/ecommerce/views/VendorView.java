package com.ooad.ecommerce.views;

import com.ooad.ecommerce.dto.ProductDto;
import com.ooad.ecommerce.dto.UserInfoDto;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import java.util.List;
import javax.annotation.security.PermitAll;

@PageTitle("Buffkart - Vendor")
@Route(value = "vendor", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@PermitAll
public class VendorView extends VerticalLayout {

  public VendorView() {
    Button plusButton = new Button(new Icon(VaadinIcon.PLUS));
    plusButton.addThemeVariants(ButtonVariant.LUMO_ICON);
    plusButton.setText("Add Product");

    Div cards = new Div();
    cards.addClassName("row");
    for (int i = 0; i < 10; i++) {
      cards.add(createColumn());
    }
    add(cards, plusButton);
  }

  private Component createColumn() {
    Div col = new Div();
    col.addClassName("column");
    col.add(createCard());
    return col;
  }

  private Component createCard() {
    Div card = new Div();
    Div container = new Div();
    Image img = new Image();
    img.setSrc("icons/icon.png");
    img.addClassName("product-image");
    container.add(img);
    container.add(new H4("Product Name"));
    container.add(new Paragraph("Description"));
    container.addClassName("container");
    card.add(container);
    card.addClassName("card");
    return card;
  }

  private void postProduct() {}

  private void putProduct() {}

  public List<ProductDto> getMyProducts() {
    return null;
  }

  public UserInfoDto getUserDetails() {
    return null;
  }
}
