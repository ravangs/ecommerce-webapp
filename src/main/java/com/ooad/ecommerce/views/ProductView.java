package com.ooad.ecommerce.views;

import com.ooad.ecommerce.controller.ProductController;
import com.ooad.ecommerce.dto.ProductDto;
import com.ooad.ecommerce.model.Product;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import javax.annotation.security.PermitAll;

@PageTitle("Buffkart - Product")
@Route(value = "product/:product_id", layout = MainLayout.class)
@PermitAll
public class ProductView extends VerticalLayout implements BeforeEnterObserver {

  Integer productId;
  ProductController productController;

  ProductView(ProductController productController) {
    this.productController = productController;
  }

  @Override
  public void beforeEnter(BeforeEnterEvent event) {
    productId = Integer.valueOf(event.getRouteParameters().get("product_id").get());
    renderProductPage();
  }

  public void renderProductPage() {
    ProductDto product = this.getProductDetails(this.productId);
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
    productDetails.add(new H1(product.getProductName()));
    productDetails.add(new H3(product.getProductInfo()));
    productDetails.add(new H2("Cost: " + product.getCost()));
    rightPanel.add(productDetails);
    return rightPanel;
  }

  public ProductDto getProductDetails(Integer productId) {
    return this.productController.getProductDetails(productId);
  }
}
