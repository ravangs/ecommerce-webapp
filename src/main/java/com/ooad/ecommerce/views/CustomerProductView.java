package com.ooad.ecommerce.views;


import com.ooad.ecommerce.controller.CartController;
import com.ooad.ecommerce.controller.ProductController;
import com.ooad.ecommerce.dto.ModifyCartDto;
import com.ooad.ecommerce.dto.ProductDto;
import com.ooad.ecommerce.service.AuthService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.PermitAll;
import java.util.ArrayList;
import java.util.List;

@PageTitle("Buffkart - Product")
// The definition of layout is an example of composite pattern
// as the UI is generated in a tree fashion with MainLayout as the root
@Route(value = "customer-product/:product_id", layout = MainLayout.class)
@PermitAll
public class CustomerProductView  extends VerticalLayout implements BeforeEnterObserver {

  Integer productId;
  ProductController productController;

  CartController cartController;

  AuthService authService;

  CustomerProductView(ProductController productController, CartController cartController, AuthService authService) {
    this.productController = productController;
    this.cartController = cartController;
    this.authService = authService;
  }

  @Override
  public void beforeEnter(BeforeEnterEvent event) {
    productId = Integer.valueOf(event.getRouteParameters().get("product_id").get());
    renderProductPage();
  }

  public void renderProductPage() {
    ProductDto product = this.productController.getProductDetails(productId);
    Div container = new Div();
    container.addClassName("product-container");
    container.add(renderProductImage(product), renderProductDetails(product));
    add(container);
  }

  public Div renderProductImage(ProductDto product) {
    Div leftPanel = new Div();
    leftPanel.addClassName("left-column");
    String imgPath = "images/" + product.getProductImagePath();
    imgPath = imgPath.replaceAll("[\uFEFF-\uFFFF]", "");
    Image img = new Image();
    img.setSrc(imgPath);
    leftPanel.add(img);
    img.addClassName("product-image");
    return leftPanel;
  }

  public Div renderProductDetails(ProductDto product) {
    Div rightPanel = new Div();
    rightPanel.addClassName("right-column");
    Div productDetails = new Div();
    productDetails.addClassName("product-description");

    Div productName = new Div();
    Paragraph productNameValue = new Paragraph(product.getProductName());
    productName.addClassName("product-name");
    productNameValue.addClassName("product-name-value");

    productName.add(productNameValue);

    Div productInfo = new Div();
    Paragraph productInfoValue = new Paragraph(product.getProductInfo());
    productInfo.add(productInfoValue);
    productInfo.addClassName("product-info");
    productInfoValue.addClassName("product-info-value");

    Div productStock = new Div();
    Paragraph productStockValue = new Paragraph("Qty: ");
    ComboBox<Integer> quantity = new ComboBox<>();
    quantity.setItems(getQuantityOptions(product.getStock()));
    quantity.setValue(1);
    productStock.add(productStockValue, quantity);
    productStock.addClassName("product-stock");
    productStockValue.addClassName("product-stock-value");

    Div productCost = new Div();
    Paragraph productCostValue = new Paragraph("Cost: " + product.getCost());
    productCost.add(productCostValue);
    productCost.addClassName("product-cost");
    productCostValue.addClassName("product-cost-value");

    Button addToCart = new Button("Add to Cart");
    addToCart.addClickListener(
        e -> {
          // This is an example of command pattern as we are assigning a command to the click event
          this.addProductToCart(quantity.getValue());
          UI.getCurrent().navigate("");
        });

    productDetails.add(productName, productInfo, productStock, productCost, addToCart);
    rightPanel.add(productDetails);
    return rightPanel;
  }

  public void addProductToCart(Integer quantity) {
    List<ModifyCartDto> cart = new ArrayList<>();
    ModifyCartDto cartItem = ModifyCartDto.builder().productId(productId).userId(authService.getUserId()).quantity(quantity).build();
    cart.add(cartItem);
    this.cartController.modifyCart(cart);
  }

  public List<Integer> getQuantityOptions(Integer stock) {
    List<Integer> quantity = new ArrayList<>();
    for(int i = 1; i <= stock; i++) {
      quantity.add(i);
    }
    return quantity;
  }
}
