package com.ooad.ecommerce.repository;

import com.ooad.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserName(String username);

}
