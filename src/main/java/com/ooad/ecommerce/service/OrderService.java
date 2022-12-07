package com.ooad.ecommerce.service;

import com.ooad.ecommerce.model.Order;
import com.ooad.ecommerce.model.OrderDetail;
import com.ooad.ecommerce.model.OrderDetailId;
import com.ooad.ecommerce.model.Product;
import com.ooad.ecommerce.repository.OrderDetailRepository;
import com.ooad.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class OrderService {

  @Autowired private OrderRepository orderRepository;

  @Autowired private OrderDetailRepository orderDetailRepository;

  public void placeOrder(Integer userId, Map<Product, Integer> cartDetails) {
    Order order = saveOrder(userId,cartDetails);
    saveOrderDetail(order, cartDetails);
  }

  private void saveOrderDetail(Order order, Map<Product, Integer> cartDetails) {
    List<OrderDetail> orderDetails = cartDetails.entrySet().stream().map(entry -> createOrderDetailEntity(order, entry)).toList();
    orderDetailRepository.saveAll(orderDetails);
  }

  private OrderDetail createOrderDetailEntity(Order order, Map.Entry<Product, Integer> entry) {
    OrderDetail orderDetail = new OrderDetail();
    OrderDetailId orderDetailId = new OrderDetailId();
    orderDetailId.setOrderId(order.getId());
    orderDetailId.setProductId(entry.getKey().getId());
    orderDetail.setId(orderDetailId);
    orderDetail.setQuantity(entry.getValue());
    return orderDetail;
  }

  private Order saveOrder(Integer userId, Map<Product, Integer> cartDetails){
    double cost = 0;
    for (var entry: cartDetails.entrySet()){
      cost += (entry.getKey().getCost() * entry.getValue());
    }
    Order order = new Order();
    order.setUserId(userId);
    order.setOrderDate(Instant.now());
    order.setTotalCost(cost);
    return orderRepository.save(order);
  }

  public List<Order> getOrders(Integer userId) {
    return orderRepository.findAllByUserIdOrderByOrderDateDesc(userId);
  }


  public Order getOrder(Integer orderId) {
    Optional<Order> order = orderRepository.findById(orderId);
    return order.orElseGet(Order::new);
  }
}
