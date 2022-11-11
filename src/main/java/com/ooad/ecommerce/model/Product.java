package com.ooad.ecommerce.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(
    name = "product",
    schema = "ecommerce",
    indexes = {
      @Index(
          name = "product_product_name_vendor_id_uindex",
          columnList = "product_name, vendor_id",
          unique = true)
    })
public class Product {
  @Id
  @Column(name = "product_id", nullable = false)
  private Integer id;

  @Size(max = 127)
  @NotNull
  @Column(name = "product_name", nullable = false, length = 127)
  private String productName;

  @NotNull
  @Column(name = "product_info", nullable = false)
  private byte[] productInfo;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "vendor_id", nullable = false)
  private User vendor;

  @NotNull
  @Column(name = "stock", nullable = false)
  private Integer stock;

  @NotNull
  @Column(name = "cost", nullable = false)
  private Double cost;

  @Column(name = "discount")
  private Integer discount;

  @NotNull
  @Column(name = "product_image_path", nullable = false)
  private byte[] productImagePath;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public byte[] getProductInfo() {
    return productInfo;
  }

  public void setProductInfo(byte[] productInfo) {
    this.productInfo = productInfo;
  }

  public User getVendor() {
    return vendor;
  }

  public void setVendor(User vendor) {
    this.vendor = vendor;
  }

  public Integer getStock() {
    return stock;
  }

  public void setStock(Integer stock) {
    this.stock = stock;
  }

  public Double getCost() {
    return cost;
  }

  public void setCost(Double cost) {
    this.cost = cost;
  }

  public Integer getDiscount() {
    return discount;
  }

  public void setDiscount(Integer discount) {
    this.discount = discount;
  }

  public byte[] getProductImagePath() {
    return productImagePath;
  }

  public void setProductImagePath(byte[] productImagePath) {
    this.productImagePath = productImagePath;
  }
}
