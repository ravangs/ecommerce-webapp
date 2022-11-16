package com.ooad.ecommerce.controller;

import com.ooad.ecommerce.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/v1/api")
public class LoginController {

  @Autowired private LoginService loginService;

//  @GetMapping("login")
//  public boolean login() {
//    return false;
//  }

//  @GetMapping
//  public boolean signup() {
//    return false;
//  }
}
