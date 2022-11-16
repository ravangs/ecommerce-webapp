package com.ooad.ecommerce.repository;

import com.ooad.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
  public List<User> findAllByUserTypeIs(@NotNull String userType);
}
