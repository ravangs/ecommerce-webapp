package com.ooad.ecommerce.dto;

import com.ooad.ecommerce.model.Order;
import com.ooad.ecommerce.model.OrderDetailId;
import com.ooad.ecommerce.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/** A DTO for the {@link com.ooad.ecommerce.model.OrderDetail} entity */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetailDto {
  private OrderDetailId id;
  private Order order;
  private Product product;
  @NotNull private Integer quantity;
}
