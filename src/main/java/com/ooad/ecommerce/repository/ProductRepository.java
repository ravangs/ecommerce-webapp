package com.ooad.ecommerce.repository;

import com.ooad.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

  Product getProductById(Integer productId);

  List<Product> getProductsByVendorId(Integer vendorId);

  List<Product> getAllBy();
}
