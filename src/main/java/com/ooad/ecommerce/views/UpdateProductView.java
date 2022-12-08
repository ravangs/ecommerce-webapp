package com.ooad.ecommerce.views;

import com.ooad.ecommerce.dto.ProductDto;
import com.ooad.ecommerce.service.AuthService;
import com.ooad.ecommerce.service.UpdateProductHelperService;
import com.ooad.ecommerce.service.VendorService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.io.InputStream;
import javax.annotation.security.PermitAll;

@PageTitle("Buffkart - Update Product")
// The definition of layout is an example of composite pattern
// as the UI is generated in a tree fashion with MainLayout as the root
@Route(value = "update-product", layout = MainLayout.class)
@PermitAll
public class UpdateProductView extends VerticalLayout {
  AuthService authService;
  VendorService vendorService;
  UpdateProductHelperService updateProductHelperService;
  ExistingProduct product;
  Binder<ExistingProduct> binder;
  String fileName;
  InputStream inputStream;

  public UpdateProductView(
      AuthService authService,
      VendorService vendorService,
      UpdateProductHelperService updateProductHelperService) {

    add(new H2("Edit Product"));

    this.authService = authService;
    this.vendorService = vendorService;
    this.updateProductHelperService = updateProductHelperService;

    binder = new Binder<>();

    TextField productName = new TextField("Product Name");
    TextArea productInfo = new TextArea("Description");
    TextField stock = new TextField("Stock");
    TextField cost = new TextField("Cost");

    binder
        .forField(productName)
        .bind(ExistingProduct::getProductName, ExistingProduct::setProductName);
    binder
        .forField(productInfo)
        .bind(ExistingProduct::getProductInfo, ExistingProduct::setProductInfo);
    binder.forField(stock).bind(ExistingProduct::getStock, ExistingProduct::setStock);
    binder.forField(cost).bind(ExistingProduct::getCost, ExistingProduct::setCost);
    product = convertProductToExistingProduct(this.updateProductHelperService.getProduct());
    binder.readBean(product);

    FormLayout productForm = new FormLayout();
    productForm.setResponsiveSteps(new FormLayout.ResponsiveStep("0", 1));
    productForm.add(productName, productInfo, stock, cost);
    Button submitForm = new Button("Submit");
    submitForm.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
    submitForm.addClickListener(
        event -> {
          createProduct();
        });

    add(productForm, submitForm);
  }

  public void createProduct() {
    try {
      binder.writeBean(product);
    } catch (ValidationException e) {
      throw new RuntimeException(e);
    }
    ProductDto product = createProductPayload();
    this.vendorService.updateProduct(product);
    UI.getCurrent().navigate("product/" + product.getId());
  }

  public ProductDto createProductPayload() {
    return ProductDto.builder()
        .productInfo(product.getProductInfo())
        .productImagePath(product.getProductImagePath())
        .vendorId(product.getVendorId())
        .productName(product.getProductName())
        .stock(Integer.valueOf(product.getStock()))
        .cost(Double.valueOf(product.getCost()))
        .id(product.getId())
        .build();
  }

  public ExistingProduct convertProductToExistingProduct(ProductDto productDto) {
    ExistingProduct existingProduct = new ExistingProduct();
    existingProduct.setVendorId(productDto.getVendorId());
    existingProduct.setProductImagePath(productDto.getProductImagePath());
    existingProduct.setProductInfo(productDto.getProductInfo());
    existingProduct.setProductName(productDto.getProductName());
    existingProduct.setCost(String.valueOf(productDto.getCost()));
    existingProduct.setStock(String.valueOf(productDto.getStock()));
    existingProduct.setId(productDto.getId());
    return existingProduct;
  }
}

class ExistingProduct {
  String productName;
  String productInfo;
  String cost;
  String stock;

  String productImagePath;
  Integer vendorId;
  Integer id;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getProductImagePath() {
    return productImagePath;
  }

  public void setProductImagePath(String productImagePath) {
    this.productImagePath = productImagePath;
  }

  public Integer getVendorId() {
    return vendorId;
  }

  public void setVendorId(Integer vendorId) {
    this.vendorId = vendorId;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getProductInfo() {
    return productInfo;
  }

  public void setProductInfo(String productInfo) {
    this.productInfo = productInfo;
  }

  public String getCost() {
    return cost;
  }

  public void setCost(String cost) {
    this.cost = cost;
  }

  public String getStock() {
    return stock;
  }

  public void setStock(String stock) {
    this.stock = stock;
  }
}
