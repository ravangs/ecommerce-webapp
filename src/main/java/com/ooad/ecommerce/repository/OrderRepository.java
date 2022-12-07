package com.ooad.ecommerce.repository;

import com.ooad.ecommerce.model.Order;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
  List<Order> findAllByUserIdOrderByOrderDateDesc(Integer userId);
}
