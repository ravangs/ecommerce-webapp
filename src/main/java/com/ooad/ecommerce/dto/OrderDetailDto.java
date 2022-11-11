package com.ooad.ecommerce.dto;

import com.ooad.ecommerce.model.Order;
import com.ooad.ecommerce.model.OrderDetailId;
import com.ooad.ecommerce.model.Product;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** A DTO for the {@link com.ooad.ecommerce.model.OrderDetail} entity */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDto implements Serializable {
  private OrderDetailId id;
  private Order order;
  private Product product;
  @NotNull private Integer quantity;
}