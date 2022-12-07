package com.ooad.ecommerce.dto;

import com.ooad.ecommerce.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

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

  public Product convertDtoToEntity() {
    Product product = new Product();
    if (this.getId() != null) {
      product.setId(this.getId());
    }
    product.setProductName(this.getProductName());
    product.setProductInfo(this.getProductInfo().getBytes());
    product.setVendorId(this.getVendorId());
    product.setStock(this.getStock());
    product.setCost(this.getCost());
    product.setDiscount(this.getDiscount());
    product.setProductImagePath(
        this.getProductImagePath().replaceAll("[\uFEFF-\uFFFF]", "").getBytes());
    return product;
  }
}
