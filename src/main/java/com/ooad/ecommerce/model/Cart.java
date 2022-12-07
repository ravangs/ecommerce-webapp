package com.ooad.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cart", schema = "ecommerce")
public class Cart {
  @EmbeddedId private CartId id;

  @NotNull
  @Column(name = "quantity", nullable = false)
  private Integer quantity;

  public CartId getId() {
    return id;
  }

  public void setId(CartId id) {
    this.id = id;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
}
