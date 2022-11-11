package com.ooad.ecommerce.model;

import javax.persistence.*;

@Entity
@Table(name = "favourite", schema = "ecommerce")
public class Favourite {
  @EmbeddedId private FavouriteId id;

  @MapsId("productId")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "product_id", nullable = false)
  private Product product;

  @MapsId("userId")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  public FavouriteId getId() {
    return id;
  }

  public void setId(FavouriteId id) {
    this.id = id;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
