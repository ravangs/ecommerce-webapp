package com.ooad.ecommerce.dto;

import com.ooad.ecommerce.model.Product;
import com.ooad.ecommerce.model.UserInfo;
import com.ooad.ecommerce.view.CustomerView;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** A DTO for the {@link Product} entity */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto extends CustomerView implements Serializable {
  private Integer id;

  @Size(max = 127)
  @NotNull
  private String productName;

  @NotNull private byte[] productInfo;
  @NotNull private UserInfo vendor;
  @NotNull private Integer stock;
  @NotNull private Double cost;
  private Integer discount;
  @NotNull private byte[] productImagePath;
}
