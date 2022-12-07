package com.ooad.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModifyFavouriteDto {
    private Integer productId;
    private Integer userId;
}
