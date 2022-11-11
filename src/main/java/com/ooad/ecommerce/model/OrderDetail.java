package com.ooad.ecommerce.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "order_detail", schema = "ecommerce")
public class OrderDetail {
  @EmbeddedId private OrderDetailId id;

  @MapsId("orderId")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "order_id", nullable = false)
  private Order order;

  @MapsId("productId")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "product_id", nullable = false)
  private Product product;

  @NotNull
  @Column(name = "quantity", nullable = false)
  private Integer quantity;

  public OrderDetailId getId() {
    return id;
  }

  public void setId(OrderDetailId id) {
    this.id = id;
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
}
