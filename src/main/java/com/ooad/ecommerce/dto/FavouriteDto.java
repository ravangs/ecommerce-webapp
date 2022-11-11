package com.ooad.ecommerce.dto;

import com.ooad.ecommerce.model.*;
import com.ooad.ecommerce.view.FavouriteView;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** A DTO for the {@link Favourite} entity */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavouriteDto extends FavouriteView implements Serializable {
  private FavouriteId id;
  private Product product;
  private UserInfo user;
}
