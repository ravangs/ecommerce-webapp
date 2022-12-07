package com.ooad.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "order_detail", schema = "ecommerce")
public class OrderDetail {
  @EmbeddedId private OrderDetailId id;

  @NotNull
  @Column(name = "quantity", nullable = false)
  private Integer quantity;

  public OrderDetailId getId() {
    return id;
  }

  public void setId(OrderDetailId id) {
    this.id = id;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
}
