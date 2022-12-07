package com.ooad.ecommerce.views;

import com.ooad.ecommerce.dto.ProductDto;
import com.ooad.ecommerce.service.AuthService;
import com.ooad.ecommerce.service.VendorService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.PermitAll;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@PageTitle("Buffkart - New Product")
@Route(value = "new-product", layout = MainLayout.class)
@PermitAll
public class NewProductView extends VerticalLayout {
  AuthService authService;
  VendorService vendorService;
  NewProduct newProduct = new NewProduct();
  Binder<NewProduct> binder;
  String fileName;
  InputStream inputStream;

  public NewProductView(AuthService authService, VendorService vendorService) {
    this.authService = authService;
    this.vendorService = vendorService;

    binder = new Binder<>();

    TextField productName = new TextField("Product Name");
    TextArea productInfo = new TextArea("Description");
    TextField stock = new TextField("Stock");
    TextField cost = new TextField("Cost");

    binder.forField(productName).bind(NewProduct::getProductName, NewProduct::setProductName);
    binder.forField(productInfo).bind(NewProduct::getProductInfo, NewProduct::setProductInfo);
    binder.forField(stock).bind(NewProduct::getStock, NewProduct::setStock);
    binder.forField(cost).bind(NewProduct::getCost, NewProduct::setCost);

    MultiFileMemoryBuffer buffer = new MultiFileMemoryBuffer();
    Upload upload = new Upload(buffer);
    Button uploadButton = new Button("Upload Product Image");
    uploadButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

    upload.setUploadButton(uploadButton);

    upload.addSucceededListener(
        event -> {
          fileName = event.getFileName();
          inputStream = buffer.getInputStream(fileName);
        });

    FormLayout productForm = new FormLayout();
    productForm.setResponsiveSteps(new FormLayout.ResponsiveStep("0", 1));
    productForm.add(productName, productInfo, stock, cost);
    Button submitForm = new Button("Submit");
    submitForm.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
    submitForm.addClickListener(
        event -> {
          createProduct();
        });

    add(productForm, upload, submitForm);
  }

  public void createProduct() {
    try {
      binder.writeBean(newProduct);
    } catch (ValidationException e) {
      throw new RuntimeException(e);
    }
    uploadImage();
    ProductDto product = createProductPayload();
    this.vendorService.addProduct(product);
    UI.getCurrent().navigate("");
  }

  public ProductDto createProductPayload() {
    return ProductDto.builder()
        .productInfo(newProduct.getProductInfo())
        .productImagePath(fileName)
        .vendorId(authService.getUserId())
        .productName(newProduct.getProductName())
        .stock(Integer.valueOf(newProduct.getStock()))
        .cost(Double.valueOf(newProduct.getCost()))
        .build();
  }

  public void uploadImage() {
    File file = new File(this.authService.getImgPath() + fileName);
    BufferedImage bi = null;
    try {
      bi = ImageIO.read(inputStream);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    try {
      ImageIO.write(bi, "jpg", file);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}

class NewProduct {
  String productName;
  String productInfo;
  String cost;
  String stock;

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
