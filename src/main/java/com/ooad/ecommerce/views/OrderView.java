package com.ooad.ecommerce.views;

import com.ooad.ecommerce.controller.CartController;
import com.ooad.ecommerce.controller.OrderController;
import com.ooad.ecommerce.model.Order;
import com.ooad.ecommerce.model.Product;
import com.ooad.ecommerce.service.AuthService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.PermitAll;
import java.util.Map;

@PageTitle("Buffkart - Product")
// The definition of layout is an example of composite pattern
// as the UI is generated in a tree fashion with MainLayout as the root
@Route(value = "order/:order_id", layout = MainLayout.class)
@PermitAll
public class OrderView extends VerticalLayout implements BeforeEnterObserver {
  Integer orderId;

  OrderController orderController;
  public OrderView(OrderController orderController) {
    this.orderController = orderController;
  }
  @Override
  public void beforeEnter(BeforeEnterEvent event) {
    orderId = Integer.valueOf(event.getRouteParameters().get("order_id").get());
    renderOrderPage();
  }

  public void renderOrderPage() {
    add(new H2("Order Details"));
    Double total = 0.0;
    Map<Product, Integer> cartItems = this.orderController.getOrderByOrderId(orderId);
    for (Map.Entry<Product, Integer> cartItem : cartItems.entrySet()) {
      add(createCartCard(cartItem.getKey(), cartItem.getValue()));
      total = total + (cartItem.getValue() * cartItem.getKey().getCost());
    }
  }

  public Component createCartCard(Product product, Integer quantity) {
    Div card = new Div();
    Image img = new Image();
    img.addClassName("cart-item-image");
    String imgPath = "images/" + new String(product.getProductImagePath());
    imgPath = imgPath.replaceAll("[\uFEFF-\uFFFF]", "");
    img.setSrc(imgPath);
    card.add(img);
    card.addClassName("cart-item");

    Div cartItemDetails = new Div();

    Paragraph itemName = new Paragraph("Product Name: " + product.getProductName());
    Paragraph itemCost = new Paragraph("Cost: " + product.getCost());
    Paragraph itemQty = new Paragraph("Qty: " + quantity);
    itemQty.addClassName("cart-item-info");
    itemCost.addClassName("cart-item-info");
    itemName.addClassName("cart-item-info");

    cartItemDetails.add(itemName, itemCost, itemQty);

    card.add(cartItemDetails);
    return card;
  }

}
