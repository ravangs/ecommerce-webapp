package com.ooad.ecommerce.dto;

import com.ooad.ecommerce.model.*;
import com.ooad.ecommerce.view.CartView;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** A DTO for the {@link Cart} entity */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto extends CartView implements Serializable {
  private CartId id;
  private Product product;
  private UserInfo user;
  @NotNull private Integer quantity;
}
