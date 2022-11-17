package com.ooad.ecommerce.dto;

import com.ooad.ecommerce.model.Cart;
import com.ooad.ecommerce.model.CartId;
import com.ooad.ecommerce.model.Product;
import com.ooad.ecommerce.model.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/** A DTO for the {@link Cart} entity */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto implements Serializable {
  private CartId id;
  private Product product;
  private UserInfo user;
  @NotNull private Integer quantity;
}
