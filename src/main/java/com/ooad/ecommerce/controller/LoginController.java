package com.ooad.ecommerce.controller;

import com.ooad.ecommerce.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

  @Autowired private LoginService loginService;

  @GetMapping
  public boolean login() {}

  @GetMapping
  public boolean signup() {}
}
