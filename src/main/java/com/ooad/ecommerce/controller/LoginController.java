package com.ooad.ecommerce.controller;

import com.ooad.ecommerce.dto.SignUpDto;
import com.ooad.ecommerce.model.UserInfo;
import com.ooad.ecommerce.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
public class LoginController {

  @Autowired private LoginService loginService;

  @PostMapping(
      value = "/signup",
      consumes = {MediaType.APPLICATION_JSON_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public UserInfo signup(@RequestBody SignUpDto userDetails) {
    return loginService.signup(userDetails);
  }
}
