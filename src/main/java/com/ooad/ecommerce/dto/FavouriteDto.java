package com.ooad.ecommerce.dto;

import com.ooad.ecommerce.model.Favourite;
import com.ooad.ecommerce.model.FavouriteId;
import com.ooad.ecommerce.model.Product;
import com.ooad.ecommerce.model.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/** A DTO for the {@link Favourite} entity */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavouriteDto implements Serializable {
  private FavouriteId id;
  private Product product;
  private UserInfo user;
}
