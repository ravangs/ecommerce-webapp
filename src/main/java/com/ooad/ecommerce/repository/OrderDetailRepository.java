package com.ooad.ecommerce.repository;

import com.ooad.ecommerce.model.OrderDetail;
import com.ooad.ecommerce.model.OrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {}
