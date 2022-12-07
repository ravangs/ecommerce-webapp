package com.ooad.ecommerce.model;

import java.time.Instant;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(
    name = "`order`",
    schema = "ecommerce",
    indexes = {@Index(name = "order_user_id_index", columnList = "user_id")})
public class Order {
  @Id
  @Column(name = "order_id", nullable = false)
  private Integer id;

  @NotNull
  @Column(name = "user_id", nullable = false)
  private Integer userId;

  @NotNull
  @Column(name = "order_date", nullable = false)
  private Instant orderDate;

  @NotNull
  @Column(name = "total_cost", nullable = false)
  private Double totalCost;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer user) {
    this.userId = user;
  }

  public Instant getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(Instant orderDate) {
    this.orderDate = orderDate;
  }

  public Double getTotalCost() {
    return totalCost;
  }

  public void setTotalCost(Double totalCost) {
    this.totalCost = totalCost;
  }
}
