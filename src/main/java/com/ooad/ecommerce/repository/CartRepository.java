package com.ooad.ecommerce.repository;

import com.ooad.ecommerce.model.Cart;
import com.ooad.ecommerce.model.CartId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, CartId> {
}