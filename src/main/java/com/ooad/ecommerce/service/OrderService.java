package com.ooad.ecommerce.service;

import com.ooad.ecommerce.repository.OrderDetailRepository;
import com.ooad.ecommerce.repository.OrderRepository;
import com.ooad.ecommerce.repository.UserInfoRepository;
import com.ooad.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;


    private void placeOrder(){

    }
}
