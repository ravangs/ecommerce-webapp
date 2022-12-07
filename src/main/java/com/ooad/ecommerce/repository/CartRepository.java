package com.ooad.ecommerce.repository;

import com.ooad.ecommerce.model.Cart;
import com.ooad.ecommerce.model.CartId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, CartId> {
    List<Cart> findAllByUserIdAndQuantityNot(Integer userId, Integer quantity);

    void deleteAllByUserId(Integer userId);

}
