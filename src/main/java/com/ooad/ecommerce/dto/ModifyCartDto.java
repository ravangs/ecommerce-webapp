package com.ooad.ecommerce.dto;

import com.ooad.ecommerce.model.Cart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModifyCartDto {
    private Integer productId;
    private Integer userId;
    private Integer quantity;

    public Cart convertDtoToEntity(){
        Cart cart = new Cart();
        cart.setProductId(this.productId);
        cart.setUserId(this.userId);
        cart.setQuantity(this.quantity);
        return cart;
    }
}
