package com.ooad.ecommerce.service;

import com.ooad.ecommerce.dto.ModifyCartDto;
import com.ooad.ecommerce.model.Cart;
import com.ooad.ecommerce.model.Product;
import com.ooad.ecommerce.repository.CartRepository;
import com.ooad.ecommerce.repository.ProductRepository;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CartService {

  @Autowired private CartRepository cartRepository;

  @Autowired private ProductRepository productRepository;

  public Map<Product, Integer> getCartDetails(Integer userId) {
    List<Cart> cartList = cartRepository.findAllById_UserIdAndQuantityNot(userId, 0);
    List<Product> productList =
        productRepository.findAllById(
            cartList.stream()
                .map(entry -> entry.getId().getProductId())
                .collect(Collectors.toList()));
    Map<Integer, Product> productMap =
        productList.stream().collect(Collectors.toMap(Product::getId, product -> product));
    return cartList.stream()
        .collect(
            Collectors.toMap(
                entry -> productMap.get(entry.getId().getProductId()), Cart::getQuantity));
  }

  public Map<Product, Integer> modifyCart(List<ModifyCartDto> cartEntryDetails) {
    List<Cart> cartList = cartEntryDetails.stream().map(ModifyCartDto::convertDtoToEntity).toList();
    cartRepository.saveAll(cartList);
    return getCartDetails(cartList.get(0).getId().getUserId());
  }

  @Transactional
  public void clearCart(Integer userId) {
    cartRepository.deleteAllById_UserId(userId);
  }
}
