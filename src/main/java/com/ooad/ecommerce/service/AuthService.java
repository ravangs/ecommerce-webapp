package com.ooad.ecommerce.service;

import com.ooad.ecommerce.security.AuthenticatedUser;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
  String imgPath = "src/main/resources/META-INF/resources/images/";
  AuthenticatedUser authenticatedUser;

  public AuthService(AuthenticatedUser authenticatedUser) {
    this.authenticatedUser = authenticatedUser;
  }

  public Integer getUserId() {
    return authenticatedUser.get().get().getId();
  }

  public String getImgPath() {
    return imgPath;
  }
}
