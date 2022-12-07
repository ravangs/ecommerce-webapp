package com.ooad.ecommerce.dto;

import com.ooad.ecommerce.model.Cart;
import com.ooad.ecommerce.model.CartId;
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
        CartId cartId = new CartId();
        cartId.setProductId(this.productId);
        cartId.setUserId(this.userId);
        cart.setId(cartId);
        cart.setQuantity(this.quantity);
        return cart;
    }
}
