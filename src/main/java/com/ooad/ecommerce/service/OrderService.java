package com.ooad.ecommerce.service;

import com.ooad.ecommerce.model.Order;
import com.ooad.ecommerce.model.OrderDetail;
import com.ooad.ecommerce.model.OrderDetailId;
import com.ooad.ecommerce.model.Product;
import com.ooad.ecommerce.repository.OrderDetailRepository;
import com.ooad.ecommerce.repository.OrderRepository;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ooad.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

  @Autowired private OrderRepository orderRepository;

  @Autowired private OrderDetailRepository orderDetailRepository;


  @Autowired private ProductRepository productRepository;

  public void placeOrder(Integer userId, Map<Product, Integer> cartDetails) {
    Order order = saveOrder(userId, cartDetails);
    saveOrderDetail(order, cartDetails);
  }

  private void saveOrderDetail(Order order, Map<Product, Integer> cartDetails) {
    List<OrderDetail> orderDetails =
        cartDetails.entrySet().stream()
            .map(entry -> createOrderDetailEntity(order, entry))
            .toList();
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

  private Order saveOrder(Integer userId, Map<Product, Integer> cartDetails) {
    double cost = 0;
    for (var entry : cartDetails.entrySet()) {
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

  public Map<Product, Integer> getOrder(Integer orderId) {
    List<OrderDetail> orderDetails = orderDetailRepository.findAllById_OrderId(orderId);
    List<Product> products =
        productRepository.findAllById(
            orderDetails.stream().map(orderDetail -> orderDetail.getId().getProductId()).toList());
    Map<Integer, Product> productMap =
        products.stream().collect(Collectors.toMap(Product::getId, product -> product));
    return orderDetails.stream()
        .collect(
            Collectors.toMap(
                entry -> productMap.get(entry.getId().getProductId()), OrderDetail::getQuantity));
  }
}
