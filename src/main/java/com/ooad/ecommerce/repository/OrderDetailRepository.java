package com.ooad.ecommerce.repository;

import com.ooad.ecommerce.model.OrderDetail;
import com.ooad.ecommerce.model.OrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {
    List<OrderDetail> findAllById_OrderId(@NotNull Integer id_orderId);
}
