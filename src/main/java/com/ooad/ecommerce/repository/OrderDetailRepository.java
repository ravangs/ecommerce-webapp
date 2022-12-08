package com.ooad.ecommerce.repository;

import com.ooad.ecommerce.model.OrderDetail;
import com.ooad.ecommerce.model.OrderDetailId;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {
  List<OrderDetail> findAllById_OrderId(@NotNull Integer id_orderId);
}
