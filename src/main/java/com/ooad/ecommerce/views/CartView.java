package com.ooad.ecommerce.views;

import com.ooad.ecommerce.controller.CartController;
import com.ooad.ecommerce.controller.OrderController;
import com.ooad.ecommerce.model.Product;
import com.ooad.ecommerce.service.AuthService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.PermitAll;
import java.util.Map;

@PageTitle("Buffkart - Cart")
// The definition of layout is an example of composite pattern
// as the UI is generated in a tree fashion with MainLayout as the root
@Route(value = "cart", layout = MainLayout.class)
@PermitAll
public class CartView extends VerticalLayout {

  public CartView(CartController cartController, OrderController orderController, AuthService authService) {
    add(new H2("Cart"));
    Double total = 0.0;
    Map<Product, Integer> cartItems = cartController.getCartDetails(authService.getUserId());
    for (Map.Entry<Product, Integer> cartItem : cartItems.entrySet()) {
      add(createCartCard(cartItem.getKey(), cartItem.getValue()));
      total = total + (cartItem.getValue() * cartItem.getKey().getCost());
    }

    Paragraph totalCost = new Paragraph("Total: " + total);
    totalCost.addClassName("total-cost-text");

    Button checkoutButton = new Button("Checkout");
    checkoutButton.addClassName("checkout-button");
    checkoutButton.addClickListener(event -> {
      orderController.placeOrder(authService.getUserId());
      UI.getCurrent().navigate("");
    });

    Div cartSummary = new Div();
    cartSummary.addClassName("cart-summary");
    cartSummary.add(totalCost, checkoutButton);

    add(cartSummary);
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

  private boolean putCartDetails() {
    return false;
  }
}
