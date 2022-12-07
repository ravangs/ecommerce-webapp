package com.ooad.ecommerce.repository;

import com.ooad.ecommerce.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByUserIdOrderByOrderDateDesc(Integer userId);

}
