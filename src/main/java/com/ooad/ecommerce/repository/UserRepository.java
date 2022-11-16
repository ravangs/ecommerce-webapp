package com.ooad.ecommerce.repository;

import com.ooad.ecommerce.model.User;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
  public List<User> findAllByUserTypeIs(@NotNull String userType);
}
