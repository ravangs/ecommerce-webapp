package com.ooad.ecommerce.views;

import com.ooad.ecommerce.controller.VendorController;
import com.ooad.ecommerce.dto.ProductDto;
import com.ooad.ecommerce.dto.UserInfoDto;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
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
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Buffkart - Vendor")
@Route(value = "vendor", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@PermitAll
public class VendorView extends VerticalLayout {

  public VendorView(@Autowired VendorController vendorController) {
    Button plusButton = new Button(new Icon(VaadinIcon.PLUS));
    plusButton.addThemeVariants(ButtonVariant.LUMO_ICON);
    plusButton.setText("Add Product");
    List<ProductDto> products = vendorController.getMyProducts(1);
    Div cards = new Div();
    cards.addClassName("row");
    for (ProductDto product : products) {
      cards.add(createColumn(product));
    }
    add(cards, plusButton);
  }

  private Component createColumn(ProductDto product) {
    Div col = new Div();
    col.addClassName("column");
    col.add(createCard(product));
    return col;
  }

  private Component createCard(ProductDto product) {
    Div card = new Div();
    card.addClickListener(e -> {
      UI.getCurrent().navigate("product/" + product.getId());
    });
    String imgPath = "images/" + product.getProductImagePath();
    imgPath = imgPath.replaceAll("[\uFEFF-\uFFFF]", "");
    Div container = new Div();
    Image img = new Image();
    img.setSrc(imgPath);
    img.addClassName("product-catalog-image");
    container.add(img);
    container.add(new H4(product.getProductName()));
    container.add(new Paragraph(String.valueOf(product.getCost())));
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
