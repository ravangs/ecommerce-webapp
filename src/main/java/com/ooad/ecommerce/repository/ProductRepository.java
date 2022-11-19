package com.ooad.ecommerce.repository;

import com.ooad.ecommerce.model.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

  List<Product> getProductsByVendorId(Integer vendorId);
}
