package com.ooad.ecommerce.security;

import org.springframework.security.crypto.password.PasswordEncoder;

// This is an example of Singleton Pattern
// In this scenario, eager instantiation has been used
public class PlainTextPasswordEncoder implements PasswordEncoder {

  private static final PasswordEncoder INSTANCE = new PlainTextPasswordEncoder();

  private PlainTextPasswordEncoder() {}

  public static PasswordEncoder getInstance() {
    return INSTANCE;
  }

  @Override
  public String encode(CharSequence rawPassword) {
    return rawPassword.toString();
  }

  @Override
  public boolean matches(CharSequence rawPassword, String encodedPassword) {
    return rawPassword.toString().equals(encodedPassword);
  }
}
