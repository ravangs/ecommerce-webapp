package com.ooad.ecommerce.service;

import com.ooad.ecommerce.model.User;
import com.ooad.ecommerce.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository repository;

  @Autowired
  public UserService(UserRepository repository) {
    this.repository = repository;
  }

  public Optional<User> get(Integer id) {
    return repository.findById(id);
  }

  public User update(User entity) {
    return repository.save(entity);
  }

  public void delete(Integer id) {
    repository.deleteById(id);
  }

  public Page<User> list(Pageable pageable) {
    return repository.findAll(pageable);
  }

  public int count() {
    return (int) repository.count();
  }
}
