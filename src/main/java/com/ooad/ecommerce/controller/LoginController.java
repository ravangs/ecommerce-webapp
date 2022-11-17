package com.ooad.ecommerce.controller;

import com.ooad.ecommerce.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
public class LoginController {

  @Autowired private LoginService loginService;

  @PostMapping("/login")
  public boolean login() {
    return false;
  }

  @PostMapping("/signup")
  public boolean signup() {
    return false;
  }
}
