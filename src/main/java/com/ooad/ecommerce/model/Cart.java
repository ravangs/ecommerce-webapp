package com.ooad.ecommerce.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cart", schema = "ecommerce")
public class Cart {
  @EmbeddedId private CartId id;

  @NotNull
  @JoinColumn(name = "product_id", nullable = false)
  private Integer productId;

  @NotNull
  @JoinColumn(name = "user_id", nullable = false)
  private Integer userId;

  @NotNull
  @Column(name = "quantity", nullable = false)
  private Integer quantity;

  public CartId getId() {
    return id;
  }

  public void setId(CartId id) {
    this.id = id;
  }

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer product) {
    this.productId = product;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer user) {
    this.userId = user;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
}
