package com.ooad.ecommerce.dto;

import com.ooad.ecommerce.model.Cart;
import com.ooad.ecommerce.model.CartId;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** A DTO for the {@link Cart} entity */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto implements Serializable {
  private CartId id;
  private Integer productId;
  private Integer userId;
  @NotNull private Integer quantity;
}
