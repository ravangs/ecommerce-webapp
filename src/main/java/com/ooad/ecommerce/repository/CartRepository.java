package com.ooad.ecommerce.repository;

import com.ooad.ecommerce.model.Cart;
import com.ooad.ecommerce.model.CartId;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, CartId> {
  List<Cart> findAllById_UserIdAndQuantityNot(Integer userId, Integer quantity);

  void deleteAllById_UserId(Integer userId);
}
