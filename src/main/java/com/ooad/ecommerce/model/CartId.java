package com.ooad.ecommerce.model;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CartId implements Serializable {
  private static final long serialVersionUID = -7971566816883506521L;

  @NotNull
  @Column(name = "product_id", nullable = false)
  private Integer productId;

  @NotNull
  @Column(name = "user_id", nullable = false)
  private Integer userId;

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    CartId entity = (CartId) o;
    return Objects.equals(this.productId, entity.productId)
        && Objects.equals(this.userId, entity.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, userId);
  }
}
