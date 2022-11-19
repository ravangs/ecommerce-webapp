package com.ooad.ecommerce.dto;

import com.ooad.ecommerce.model.Product;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** A DTO for the {@link Product} entity */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto implements Serializable {
  private Integer id;

  @Size(max = 127)
  @NotNull
  private String productName;

  @NotNull private String productInfo;
  @NotNull private Integer vendorId;
  @NotNull private Integer stock;
  @NotNull private Double cost;
  private Integer discount;
  @NotNull private String productImagePath;
}
