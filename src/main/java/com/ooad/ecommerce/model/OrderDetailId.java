package com.ooad.ecommerce.model;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderDetailId implements Serializable {
  private static final long serialVersionUID = 542016322799138386L;

  @NotNull
  @Column(name = "order_id", nullable = false)
  private Integer orderId;

  @NotNull
  @Column(name = "product_id", nullable = false)
  private Integer productId;

  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    OrderDetailId entity = (OrderDetailId) o;
    return Objects.equals(this.productId, entity.productId)
        && Objects.equals(this.orderId, entity.orderId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, orderId);
  }
}
