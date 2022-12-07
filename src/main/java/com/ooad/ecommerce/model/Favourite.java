package com.ooad.ecommerce.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "favourite", schema = "ecommerce")
public class Favourite {
  @EmbeddedId private FavouriteId id;

  public FavouriteId getId() {
    return id;
  }

  public void setId(FavouriteId id) {
    this.id = id;
  }
}
