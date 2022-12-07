package com.ooad.ecommerce.views;

import com.ooad.ecommerce.controller.ProductController;
import com.ooad.ecommerce.dto.ProductDto;
import com.ooad.ecommerce.service.UpdateProductHelperService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import javax.annotation.security.PermitAll;

@PageTitle("Buffkart - Product")
@Route(value = "product/:product_id", layout = MainLayout.class)
@PermitAll
public class ProductView extends VerticalLayout implements BeforeEnterObserver {

  Integer productId;
  ProductController productController;
  UpdateProductHelperService updateProductHelperService;

  ProductView(
      ProductController productController, UpdateProductHelperService updateProductHelperService) {
    this.productController = productController;
    this.updateProductHelperService = updateProductHelperService;
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

    Div productName = new Div();
    Paragraph productNameValue = new Paragraph(product.getProductName());
    productName.addClassName("product-name");
    productNameValue.addClassName("product-name-value");

    Button editButton = new Button(new Icon(VaadinIcon.PENCIL));
    editButton.addThemeVariants(ButtonVariant.LUMO_ICON);
    editButton.setText("Edit Product");
    editButton.addClickListener(
        e -> {
          this.updateProductHelperService.setProduct(product);
          UI.getCurrent().navigate("update-product");
        });
    editButton.setClassName("product-edit-button");
    productName.add(productNameValue, editButton);

    Div productInfo = new Div();
    Paragraph productInfoValue = new Paragraph(product.getProductInfo());
    productInfo.add(productInfoValue);
    productInfo.addClassName("product-info");
    productInfoValue.addClassName("product-info-value");

    Div productStock = new Div();
    Paragraph productStockValue = new Paragraph("Stock Remaining: " + product.getStock());
    productStock.add(productStockValue);
    productStock.addClassName("product-stock");
    productStockValue.addClassName("product-stock-value");

    Div productCost = new Div();
    Paragraph productCostValue = new Paragraph("Cost: " + product.getCost());
    productCost.add(productCostValue);
    productCost.addClassName("product-cost");
    productCostValue.addClassName("product-cost-value");

    productDetails.add(productName, productInfo, productStock, productCost);
    rightPanel.add(productDetails);
    return rightPanel;
  }

  public ProductDto getProductDetails(Integer productId) {
    return this.productController.getProductDetails(productId);
  }
}
