package com.ooad.ecommerce.views;

import com.ooad.ecommerce.dto.ProductDto;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;

public class CardLayoutHelper {

  public Component createColumn(ProductDto product) {
    Div col = new Div();
    col.addClassName("column");
    col.add(createCard(product));
    return col;
  }

  private Component createCard(ProductDto product) {
    Div card = new Div();
    card.addClickListener(
        e -> {
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
}
