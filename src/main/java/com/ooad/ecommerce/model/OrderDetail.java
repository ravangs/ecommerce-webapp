package com.ooad.ecommerce.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "order_detail", schema = "ecommerce")
public class OrderDetail {
  @EmbeddedId private OrderDetailId id;

  @NotNull
  @Column(name = "order_id", nullable = false)
  private Integer orderId;

  @NotNull
  @Column(name = "product_id", nullable = false)
  private Integer productId;

  @NotNull
  @Column(name = "quantity", nullable = false)
  private Integer quantity;

  public OrderDetailId getId() {
    return id;
  }

  public void setId(OrderDetailId id) {
    this.id = id;
  }

  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer order) {
    this.orderId = order;
  }

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer product) {
    this.productId = product;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
}
