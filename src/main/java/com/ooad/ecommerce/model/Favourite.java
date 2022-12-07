package com.ooad.ecommerce.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "favourite", schema = "ecommerce")
public class Favourite {
  @EmbeddedId private FavouriteId id;

  @NotNull
  @JoinColumn(name = "product_id", nullable = false)
  private Integer productId;

  @NotNull
  @JoinColumn(name = "user_id", nullable = false)
  private Integer userId;

  public FavouriteId getId() {
    return id;
  }

  public void setId(FavouriteId id) {
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
}
